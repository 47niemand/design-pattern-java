import java.util.ArrayList;
import java.util.List;

public class Visitor
{
	public static void main(String args[])
	{
		Medicine a = new MedicineA("板藍根", 11.0);
		Medicine b = new MedicineB("感康", 14.3);
		
		Prescription prescription = new Prescription();
		prescription.addMedicine(a);
		prescription.addMedicine(b);
		
		VisitorPersion charger = new Charger();
		charger.setName("BigMaMa");
		
		VisitorPersion pharmacy = new WorkerOfPharmacy();
		pharmacy.setName("Kids");

		prescription.accept(charger);
		System.out.println("----------------------------------------");
		prescription.accept(pharmacy);
	}
}

// visitor
abstract class VisitorPersion
{
	protected String name;

	public void setName(String name)
	{
		this.name = name;
	}

	public abstract void visitor(MedicineA a);

	public abstract void visitor(MedicineB b);
}

// Constructor
class Charger extends VisitorPersion
{
	@Override
	public void visitor(MedicineA a)
	{
		System.out.println("Charger : " + name + " give the medicine " + a.getName() + " price : " + a.getPrice());
	}

	@Override
	public void visitor(MedicineB b)
	{
		System.out.println("Charger : " + name + " give the medicine " + b.getName() + " price : " + b.getPrice());
	}
}

class WorkerOfPharmacy extends VisitorPersion
{
	@Override
	public void visitor(MedicineA a)
	{
		System.out.println("Pharmacy : " + name + " get the medicine " + a.getName());
	}

	@Override
	public void visitor(MedicineB b)
	{
		System.out.println("Pharmacy : " + name + " get the medicine " + b.getName());
	}
}

// Node
abstract class Medicine
{
	protected String name;
	protected double price;

	public Medicine(String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public abstract void accept(VisitorPersion visitor);
}

class MedicineA extends Medicine
{
	public MedicineA(String name, double price)
	{
		super(name, price);
	}

	@Override
	public void accept(VisitorPersion visitor)
	{
		visitor.visitor(this);
	}
}

class MedicineB extends Medicine
{
	public MedicineB(String name, double price)
	{
		super(name, price);
	}

	@Override
	public void accept(VisitorPersion visitor)
	{
		visitor.visitor(this);
	}
}

// Object Structure
class Prescription
{
	List<Medicine> list = new ArrayList<Medicine>();
	
	public void accept(VisitorPersion visitor)
	{

		for (Medicine aList : list)
		{
			aList.accept(visitor);
		}
	}
	
	public void addMedicine(Medicine medicine)
	{
		list.add(medicine);
	}
	
	public void removeMedicine(Medicine medicine)
	{
		list.remove(medicine);
	}
}