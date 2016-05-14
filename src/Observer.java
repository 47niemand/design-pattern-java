import java.util.*;

public class Observer
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        NewsPaperOffice office = new NewsPaperOffice();

        // Arvin
        Customer arvin = new Customer("Arvin");
        office.subscribeNewsPaper(arvin);

        // Jack
        Customer jack = new Customer("Jack");
        office.subscribeNewsPaper(jack);

        // Send the msg to subscribe
        office.sendNewsPaper("The News One........");

        // Describe
        office.unSubscribNewsPaper(arvin);

        // Send the msg to subscribe
        office.sendNewsPaper("The News Two........");
    }
}

// Subject
interface ISubject
{
    void registerObserver(IObserver pObserver);
    void removeObserver(IObserver pObserver);
    void notifyObserver(String pContent);
}

// Observer
interface IObserver
{
    void update(String pMessage);
}

class NewsPaperOffice implements ISubject
{
    ArrayList<IObserver> listObserver;

    public NewsPaperOffice()
    {
        listObserver = new ArrayList<IObserver>();
    }

    public void registerObserver(IObserver pObserver)
    {
        listObserver.add(pObserver);
    }

    public void removeObserver(IObserver pObserver)
    {
        if (listObserver.contains(pObserver))
        {
            listObserver.remove(pObserver);
        }
    }

    public void notifyObserver(String pContent)
    {
        for (IObserver observer : listObserver)
        {
            observer.update(pContent);
        }
    }

    public void subscribeNewsPaper(IObserver pCustomer)
    {
        registerObserver(pCustomer);
    }

    public void unSubscribNewsPaper(IObserver pCustomer)
    {
        removeObserver(pCustomer);
    }

    public void sendNewsPaper(String pContent)
    {
        System.out.println("Send the news....");
        notifyObserver(pContent);
    }
}

class Customer implements IObserver
{
    public String myName;

    public Customer(String name)
    {
        myName = name;
    }

    public void update(String pMessage)
    {
        System.out.println(myName + " receive a new message...: " + pMessage);
    }
}