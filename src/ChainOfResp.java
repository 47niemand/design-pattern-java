public class ChainOfResp
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");
        
        Leader instructor = new Instructor("Mr. Shit");
        Leader departmentHead = new DepartmentHead("Mr. Fuck");
        Leader dean = new Dean("Mr. Strong");
        Leader president = new President("Mr. Big");
        
        instructor.setSuccessor(departmentHead);
        departmentHead.setSuccessor(dean);
        dean.setSuccessor(president);
        
        instructor.handleRequest(new LeaveNote("Cool Man", 6));
        instructor.handleRequest(new LeaveNote("Pretty Girl", 4));
        instructor.handleRequest(new LeaveNote("Stupid Boy", 12));
    }
}

// Request
class LeaveNote
{
    private String name;
    private int days;

    public LeaveNote(String name, int days)
    {
        this.name = name;
        this.days = days;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getDays()
    {
        return days;
    }

    public void setDays(int days)
    {
        this.days = days;
    }
}

// Abstract Leader
abstract class Leader
{
    public String name;
    protected Leader successor;  // successor

    public Leader(String name)
    {
        this.name = name;
    }

    public void setSuccessor(Leader successor)
    {
        this.successor = successor;
    }

    public abstract void handleRequest(LeaveNote leaveNote);
}

// Constructor
class Instructor extends Leader
{
    public Instructor(String name)
    {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNote leaveNote)
    {
        if (leaveNote.getDays() <= 3)
        {
            System.out.println("Instructor " + this.name + " accept " + leaveNote.getName() + "'s leave note, number of the days are " + leaveNote.getDays() + " days." );
        }
        else
        {
            if (this.successor != null)
            {
                successor.handleRequest(leaveNote);
            }
        }
    }
}

class DepartmentHead extends Leader
{
    public DepartmentHead(String name)
    {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNote leaveNote)
    {
        if (leaveNote.getDays() <= 5)
        {
            System.out.println("Department Head " + this.name + " accept " + leaveNote.getName() + "'s leave note, number of the days are " + leaveNote.getDays() + " days." );
        }
        else
        {
            if (this.successor != null)
            {
                successor.handleRequest(leaveNote);
            }
        }
    }
    
}

class Dean extends Leader
{

    public Dean(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNote leaveNote)
    {
        if (leaveNote.getDays() <= 7)
        {
            System.out.println("Dean " + this.name + " accept " + leaveNote.getName() + "'s leave note, number of the days are " + leaveNote.getDays() + " days." );
        }
        else
        {
            if (this.successor != null)
            {
                successor.handleRequest(leaveNote);
            }
        }
    }
}

class President extends Leader
{
    public President(String name)
    {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNote leaveNote)
    {
        if (leaveNote.getDays() <= 10)
        {
            System.out.println("President " + this.name + " accept " + leaveNote.getName() + "'s leave note, number of the days are " + leaveNote.getDays() + " days." );
        }
        else
        {
            System.out.println("You have too many problem, " + this.name + " needs to consider about it!!!");
        }
    }
}