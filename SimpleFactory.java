/**
 * @author Jieyi Wu
 * @version 0.0.1
 * @since 2/1/16
 */
public class SimpleFactory
{
	public static void main(String[] args)
	{
		ChocolateFactory factory = new ChocolateFactory();
		Chocolate bar = factory.CreateChocolate("bar");
		bar.showInfo();
		Chocolate brick = factory.CreateChocolate("brick");
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
class ChocolateFactory
{
	public Chocolate CreateChocolate(String category)
	{
		if (category.equals("bar"))
		{
			return new ChocolateBar("Bar", 12.5f);
		}
		else if (category.equals("brick"))
		{
			return new ChocolateBrick("Brick", 30.0f);
		}

		return null;
	}
}