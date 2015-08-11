public class Builder
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");
        
        KFCWaiter waiter = new KFCWaiter();
        
        MealA mealA = new MealA();
        MealB mealB = new MealB();
        waiter.setMealBuilder(mealA);
        
        Meal meal = waiter.construct();
        
        System.out.println("A : " + meal.getFood() + " --- " + meal.getDrink());
        
        waiter.setMealBuilder(mealB);
        meal = waiter.construct();

        System.out.println("B : " + meal.getFood() + " --- " + meal.getDrink());
    }
}

class Meal
{
    private String food;
    private String drink;

    public String getFood()
    {
        return food;
    }

    public void setFood(String food)
    {
        this.food = food;
    }

    public String getDrink()
    {
        return drink;
    }

    public void setDrink(String drink)
    {
        this.drink = drink;
    }
}

abstract class MealBuilder
{
    protected Meal meal = new Meal();
    
    public abstract void buildFood();
    public abstract void buildDrink();
    public Meal getMeal()
    {
        return meal;
    }
}

class MealA extends MealBuilder
{

    @Override
    public void buildFood()
    {
        meal.setFood("One box of chips!");
    }

    @Override
    public void buildDrink()
    {
        meal.setDrink("One Coca cola");
    }
}

class MealB extends MealBuilder
{

    @Override
    public void buildFood()
    {
        meal.setFood("One chicken wig.");
    }

    @Override
    public void buildDrink()
    {
        meal.setDrink("One lemon tea");
    }
}

class KFCWaiter
{
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder)
    {
        this.mealBuilder = mealBuilder;
    }
    
    public Meal construct()
    {
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
        
        return mealBuilder.getMeal();
    }
}