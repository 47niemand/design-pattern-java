public class AbstractFactory
{
	public static void main(String[] args)
	{
		TaiwanSweetFactory taiwanFactory = new TaiwanSweetFactory();
		Chocolate bar = taiwanFactory.CreateChocolate();
		Candy marshmallow = taiwanFactory.CreateCandy();
		bar.showInfo();
		marshmallow.showInfo();
		
		System.out.println();

		AmericaSweetFactory americaFactory = new AmericaSweetFactory();
		Chocolate brick = americaFactory.CreateChocolate();
		Candy jellybean = americaFactory.CreateCandy();
		brick.showInfo();
		jellybean.showInfo();
	}
}

// Product chocolate
abstract class Chocolate
{
	private String name;
	private float price;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	abstract public void showInfo();
}

// Concrete Product
class ChocolateBar extends Chocolate
{
	ChocolateBar(String name, float price)
	{
		super.setName(name);
		super.setPrice(price);
	}

	@Override
	public void showInfo()
	{
		System.out.println("ChocolateBar name : " + this.getName() + " , ChocolateBar price : " + this.getPrice());
	}
}

class ChocolateBrick extends Chocolate
{
	public ChocolateBrick(String name, float price)
	{
		super.setName(name);
		super.setPrice(price);
	}

	@Override
	public void showInfo()
	{
		System.out.println("ChocolateBrick name : " + this.getName() + " , ChocolateBrick price : " + this.getPrice());
	}
}

// Product candy
abstract class Candy
{
	private String name;
	private float price;
	private String size;

	abstract public void showInfo();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}
}

class Marshmallow extends Candy
{
	public Marshmallow(String name, float price, String size)
	{
		super.setName(name);
		super.setPrice(price);
		super.setSize(size);
	}

	@Override
	public void showInfo()
	{
		System.out.println("Marshmallow name : " + this.getName() + " , Marshmallow price : " + this.getPrice() + ", Marshmallow size : " + this.getSize());
	}
}

class JellyBean extends Candy
{
	public JellyBean(String name, float price, String size)
	{
		super.setName(name);
		super.setPrice(price);
		super.setSize(size);
	}

	@Override
	public void showInfo()
	{
		System.out.println("JellyBean name : " + this.getName() + " , JellyBean price : " + this.getPrice() + ", JellyBean size : " + this.getSize());
	}
}

// Factory
interface SweetFactory
{
	public Chocolate CreateChocolate();

	public Candy CreateCandy();
}

// Concrete Factory
class TaiwanSweetFactory implements SweetFactory
{
	@Override
	public Chocolate CreateChocolate()
	{
		return new ChocolateBar("Bar", 15.3f);
	}

	@Override
	public Candy CreateCandy()
	{
		return new Marshmallow("Marshmallow", 10.2f, "Big");
	}
}

class AmericaSweetFactory implements SweetFactory
{
	@Override
	public Chocolate CreateChocolate()
	{
		return new ChocolateBrick("Brick", 27.8f);
	}

	@Override
	public Candy CreateCandy()
	{
		return new JellyBean("JellyBean", 5.9f, "Small");
	}
}