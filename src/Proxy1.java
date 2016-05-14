import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy1
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        BeautifulGirl mm = new BeautifulGirl("BeautifulGirl");

        GiveGift chum = new HerChum(mm);
        chum.giveFlower();
        chum.giveChocolate();
        chum.giveBook();

        System.out.println("static proxy ================================== dynamic proxy");

        You you = new You(mm);
        HerChumHandler dynamicChum = new HerChumHandler();
        dynamicChum.createProxy(you);
        
        // type 1
        GiveGift chum1 = (GiveGift) Proxy.newProxyInstance(GiveGift.class.getClassLoader(), new Class[] { GiveGift.class }, dynamicChum);
        chum1.giveFlower();

        // type 2
        // GiveGift chum2 = (GiveGift) dynamicChum.createProxy(new You(mm));
        // chum2.giveChocolate();
        
        // type 3
        // GiveGift chum3 = (GiveGift) Proxy.newProxyInstance(GiveGift.class.getClassLoader(), you.getClass().getInterfaces(), dynamicChum);
        // chum3.giveBook();
    }
}

// -------------------- static proxy -------------------
// Target
class BeautifulGirl
{
    private String name;

    public BeautifulGirl(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

// Interface (abstract) Subject
interface GiveGift
{
    public void giveFlower();
    public void giveChocolate();
    public void giveBook();
}

// Real Subject
class You implements GiveGift
{
    BeautifulGirl mm;

    public You(BeautifulGirl mm)
    {
        this.mm = mm;
    }

    public void giveFlower()
    {
        System.out.println(mm.getName() + ", give you a flower!");
    }

    public void giveChocolate()
    {
        System.out.println(mm.getName() + ", give you a chocolate!");
    }

    public void giveBook()
    {
        System.out.println(mm.getName() + ", give you a book!");
    }
}

// Proxy
class HerChum implements GiveGift
{
    You you;

    public HerChum(BeautifulGirl mm)
    {
        you = new You(mm);
    }

    public void giveFlower()
    {
        you.giveFlower();
    }

    public void giveChocolate()
    {
        you.giveChocolate();
    }

    public void giveBook()
    {
        you.giveBook();
    }
}

// -------------------- dynamic proxy -------------------
class HerChumHandler implements InvocationHandler
{
    private Object targetObject;

    // 創建代理對像這段也可以不在此類，也可以放在客戶端裡面
    public Object createProxy(Object targetObject)
    {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    // 此方法為必須實現的，在代理實例上處理方法調用並返回結果。在與方法關聯的代理實例上調用方法時，將在調用處理程序上調用此方法。
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object result = null;

        System.out.println("Prepare how to speak to my chum...");
        result = method.invoke(this.targetObject, args);
        System.out.println("Finally I finished my job. A_A");

        return result;
    }
}

