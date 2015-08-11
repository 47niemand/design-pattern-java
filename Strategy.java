public class Strategy
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        int a = 1, b = 13;

        Context context = new Context(new AddMethod());
        System.out.println(a + " + " + b + " = " + context.executeStrategy(a, b));
        context.setStrategy(new SubMethod());
        System.out.println(a + " - " + b + " = " + context.executeStrategy(a, b));
        context.setStrategy(new MulMethod());
        System.out.println(a + " * " + b + " = " + context.executeStrategy(a, b));
    }
}

// Strategy Interface
interface CalCluate
{
    public int doCalcluate(int a, int b);
}

// Each of Method
class AddMethod implements CalCluate
{
    public int doCalcluate(int a, int b)
    {
        return a + b;
    }
}

class SubMethod implements CalCluate
{
    public int doCalcluate(int a, int b)
    {
        return a - b;
    }
}

class MulMethod implements CalCluate
{
    public int doCalcluate(int a, int b)
    {
        return a * b;
    }
}

// Context
class Context
{
    CalCluate strategy;

    public Context(CalCluate strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(CalCluate strategy)
    {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b)
    {
        return this.strategy.doCalcluate(a, b);
    }
}