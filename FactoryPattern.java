public class FactoryPattern
{
	public static void main(String[] args)
	{
		ChocolateBarFactory barFactory = new ChocolateBarFactory();
		Chocolate bar = barFactory.CreateChocolate();
		bar.showInfo();

		ChocolateBrickFactory brickFactory = new ChocolateBrickFactory();
		Chocolate brick = brickFactory.CreateChocolate();
		brick.showInfo();
	}
}

// Product
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

// Factory
interface ChocolateFactory
{
	public Chocolate CreateChocolate();
}

// Concrete Factory
class ChocolateBarFactory implements ChocolateFactory
{
	@Override
	public Chocolate CreateChocolate()
	{
		return new ChocolateBar("Bar", 15.3f);
	}
}

class ChocolateBrickFactory implements ChocolateFactory
{
	@Override
	public Chocolate CreateChocolate()
	{
		return new ChocolateBrick("Brick", 27.8f);
	}
}