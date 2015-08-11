public class AbstractFactory
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        BeverageStore greenTeaStore = new BeverageStore(new GreenTeaFactory());
        System.out.println("A order the GreenTea");
        greenTeaStore.beverageOrder();
        System.out.println("");
        BeverageStore blackTeaStore = new BeverageStore(new BlackTeaFactory());
        System.out.println("A order the BlackTea");
        blackTeaStore.beverageOrder();
    }
}

// Product
class IBeverageProvide
{
    String name;

    public void AddMaterial()
    {
        System.out.println(name + ", Put the material~~~");
    }

    public void Brew()
    {
        System.out.println(name + ", Brew the tea~~~");
    }

    public void PouredCup()
    {
        System.out.println(name + ", Poured in the cup~~~");
    }
}

// Concreate Product
class GreenTea extends IBeverageProvide
{
    public GreenTea()
    {
        name = "GreenTea";
    }
}

class BlackTea extends IBeverageProvide
{
    public BlackTea()
    {
        name = "BlackTea";
    }
}

// Factory
abstract class Factory
{
    abstract public IBeverageProvide createBeverage();
}

// Concreate Factory
class GreenTeaFactory extends Factory
{
    public IBeverageProvide createBeverage()
    {
        return new GreenTea();
    }
}

class BlackTeaFactory extends Factory
{
    public IBeverageProvide createBeverage()
    {
        return new BlackTea();
    }
}

// Store
class BeverageStore
{
    private Factory mFactory;

    public BeverageStore(Factory factory)
    {
        mFactory = factory;
    }

    public IBeverageProvide beverageOrder()
    {
        IBeverageProvide beverage;
        beverage = mFactory.createBeverage();

        if (beverage != null)
        {
            beverage.AddMaterial();
            beverage.Brew();
            beverage.PouredCup();
        }

        return beverage;
    }
}