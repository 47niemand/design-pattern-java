import java.util.*;

public class Composite
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        CompositMenu cm = new CompositMenu("Catecory");
        CompositMenu cm_A = new CompositMenu("A brand");
        cm_A.add(new LeafMenuPhone("Android"));
        cm_A.add(new LeafMenuNB("14 inch"));
        cm_A.add(new LeafMenuNB("15 inch"));
        cm.add(cm_A);

        CompositMenu cm_B = new CompositMenu("B brand");
        cm_B.add(new LeafMenuPhone("Apple"));
        cm_B.add(new LeafMenuNB("13 inch"));
        cm_B.add(new LeafMenuNB("14 inch"));
        cm.add(cm_B);

        CompositMenu cm_sale = new CompositMenu("On sale area");
        CompositMenu cm_A2 = new CompositMenu("A brand");
        LeafMenuNB leaf_nb_14 = new LeafMenuNB("on sales 14 inch");
        LeafMenuNB leaf_nb_15 = new LeafMenuNB("on sales 15 inch");
        cm_A2.add(leaf_nb_14);
        cm_A2.add(leaf_nb_15);
        cm_A2.remove(leaf_nb_15);
        cm_sale.add(cm_A2);
        cm.add(cm_sale);

        cm.print(0);
    }
}


// interface
abstract class MenuComponent
{
    protected String name;

    public MenuComponent(String name)
    {
        this.name = name;
    }

    public abstract void print(int depth);
}

// node (menu)
class CompositMenu extends MenuComponent
{
    private ArrayList<MenuComponent> menu = new ArrayList<MenuComponent>();

    public CompositMenu(String name)
    {
        super(name);
    }

    public void add(MenuComponent m)
    {
        menu.add(m);
    }

    public void remove(MenuComponent m)
    {
        menu.remove(m);
    }

    public void print(int depth)
    {
        String dep = "";
        for (int i = 0; i < depth; i++)
        {
            dep += "-";
        }
        System.out.println(dep + this.name);

        for (MenuComponent m : menu)
        {
            m.print(depth + 1);
        }
    }
}

// leaf (phone)
class LeafMenuPhone extends MenuComponent
{
    public LeafMenuPhone(String name)
    {
        super(name);
    }

    public void print(int depth)
    {
        String dep = "";
        for (int i = 0; i < depth; i++)
        {
            dep += "-";
        }
        System.out.println(dep + name + "手機");
    }
}

// leaf (notebook)
class LeafMenuNB extends MenuComponent
{
    public LeafMenuNB(String name)
    {
        super(name);
    }

    public void print(int depth)
    {
        String dep = "";
        for (int i = 0; i < depth; i++)
        {
            dep += "-";
        }
        System.out.println(dep + name + "筆電");
    }
}