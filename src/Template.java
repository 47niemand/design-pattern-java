public class Template
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");
        
        CoffeeBeverage coffeeBeverage = new CoffeeBeverage();
        coffeeBeverage.prepareRecipe();
        
        System.out.println();
        
        TeaBeverage teaBeverage = new TeaBeverage();
        teaBeverage.prepareRecipe();
    }
}

abstract class Beverage
{
    public final void prepareRecipe()
    {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract public void brew();
    abstract public void addCondiments();
    
    public void boilWater()
    {
        System.out.println("Boiling Water...");
    }
    
    public void pourInCup()
    {
        System.out.println("Pouring into Cup...");
    }
    
    public boolean customerWantsCondiments(String answer)
    {
        return true;
    }
}

class CoffeeBeverage extends Beverage
{
    @Override
    public void brew()
    {
        System.out.println("Adding Sugar and Milk...");
    }

    @Override
    public void addCondiments()
    {
        System.out.println("Dripping Coffee through filter...");
    }

    @Override
    public boolean customerWantsCondiments(String answer)
    {
        return answer.toLowerCase().equals("y");
    }
}

class TeaBeverage extends Beverage
{

    @Override
    public void brew()
    {
        System.out.println("Adding Lemon...");    
    }

    @Override
    public void addCondiments()
    {
        System.out.println("Steeping the tea...");
    }
}