public class State
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        Account account = new Account("Jieyi");
        account.deposit(40.0f);
        account.deposit(300.0f);
        account.withdraw(170.0f);
        account.deposit(600.0f);
    }
}

// State Interface
interface IState
{
    public void stateChangeCheck(Account account);
}

// State
class SilverState implements IState
{
    private double lowerLimit;
    private double upperLimit;

    public SilverState()
    {
        lowerLimit = 0.0f;
        upperLimit = 100.0f;
    }

    public void stateChangeCheck(Account account)
    {
        System.out.println("Balance : " + account.getBalance());

        if (account.getBalance() > upperLimit)
        {
            System.out.println("State : GoldState");
            account.setState(new GoldState());
        }
        else
        {
            System.out.println("State : " + this.getClass().getSimpleName());
        }
        System.out.println();
    }
}

class GoldState implements IState
{
    private double lowerLimit;
    private double upperLimit;

    public GoldState()
    {
        lowerLimit = 100.0f;
        upperLimit = 500.0f;
    }

    public void stateChangeCheck(Account account)
    {
        System.out.println("Balance : " + account.getBalance());

        if (account.getBalance() < lowerLimit)
        {
            System.out.println("State : SilverState");
            account.setState(new SilverState());
        }
        else if (account.getBalance() > upperLimit)
        {
            System.out.println("State : Platinum");
            account.setState(new Platinum());
        }
        else
        {
            System.out.println("State : " + this.getClass().getSimpleName());
        }
        System.out.println();
    }
}

class Platinum implements IState
{
    private double lowerLimit;
    private double upperLimit;

    public Platinum()
    {
        lowerLimit = 500.0f;
        upperLimit = 5000.0f;
    }

    public void stateChangeCheck(Account account)
    {
        System.out.println("Balance : " + account.getBalance());

        if (account.getBalance() < lowerLimit)
        {
            System.out.println("State : GoldState");
            account.setState(new GoldState());
        }
        else
        {
            System.out.println("State : " + this.getClass().getSimpleName());
        }
        System.out.println();
    }
}

// Context
class Account
{
    private IState state;
    private String name;
    private double balance;

    public Account(String name)
    {
        this.name = name;
        balance = 0.0f;
        state = new SilverState();
    }

    public void setState(IState state)
    {
        this.state = state;
    }

    public void deposit(double money)
    {
        balance += money;
        System.out.println("deposit " + money + " to bank.");
        state.stateChangeCheck(this);
    }

    public void withdraw(double money)
    {
        balance -= money;
        System.out.println("withdraw " + money + " from bank.");
        state.stateChangeCheck(this);
    }

    public double getBalance()
    {
        return balance;
    }
}