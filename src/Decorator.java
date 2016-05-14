public class Decorator
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        BreakFast breakFast1 = new Toast();
        System.out.println("Order : " + breakFast1.getDescription() + ", Price : " + breakFast1.cost());

        BreakFast breakFast2 = new Toast();
        breakFast2 = new Ham(breakFast2);
        breakFast2 = new Cheese(breakFast2);
        System.out.println("Order : " + breakFast2.getDescription() + ", Price : " + breakFast2.cost());

        BreakFast breakFast3 = new Toast();
        breakFast3 = new Ham(breakFast3);
        breakFast3 = new Ham(breakFast3);
        breakFast3 = new Cheese(breakFast3);
        breakFast3 = new Cheese(breakFast3);
        System.out.println("Order : " + breakFast3.getDescription() + ", Price : " + breakFast3.cost());
    }
}


interface BreakFast
{
    public String getDescription();
    public double cost();
}


abstract class CondimentDecorator implements BreakFast
{
    protected BreakFast breakFast;
    public CondimentDecorator(BreakFast breakFast)
    {
        this.breakFast = breakFast;
    }
}

// Main
class Toast implements BreakFast
{
    public String getDescription()
    {
        return "Toast";
    }

    public double cost()
    {
        return 20;
    }
}

class Burger implements BreakFast
{
    public String getDescription()
    {
        return "Burger";
    }

    public double cost()
    {
        return 35;
    }
}

// Decorator
class Cheese extends CondimentDecorator
{
    public Cheese(BreakFast breakFast)
    {
        super(breakFast);
    }

    public String getDescription()
    {
        return breakFast.getDescription() + ", Cheese";
    }

    public double cost()
    {
        return breakFast.cost() + 5;
    }
}

class Ham extends CondimentDecorator
{
    public Ham(BreakFast breakFast)
    {
        super(breakFast);
    }

    public String getDescription()
    {
        return breakFast.getDescription() + ", Ham";
    }

    public double cost()
    {
        return breakFast.cost() + 10;
    }
}
