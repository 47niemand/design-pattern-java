import java.util.*;

public class Command
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        // Create the Invoker
        Stock abcStock = new Stock();

        // Create the commands
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        // Create the Invoker
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrder();
    }
}

// Interface (Abstract)
interface Order
{
    public void execute();
}

// Execute the command
class Stock
{
    private String name = "ABC";
    private int quantity = 10;

    public void buy()
    {
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }

    public void sell()
    {
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}

// Command
class BuyStock implements Order
{
    private Stock abcStock;

    public BuyStock(Stock abcStock)
    {
        this.abcStock = abcStock;
    }

    public void execute()
    {
        abcStock.buy();
    }
}

class SellStock implements Order
{
    private Stock abcStock;

    public SellStock(Stock abcStock)
    {
        this.abcStock = abcStock;
    }

    public void execute()
    {
        abcStock.sell();
    }
}

// Invoker
class Broker
{
    private ArrayList<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order)
    {
        orderList.add(order);
    }

    public void placeOrder()
    {
        for (Order order : orderList)
        {
            order.execute();
        }
    }
}