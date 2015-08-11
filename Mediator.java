public class Mediator
{
	public static void main(String args[])
	{
		MediatorFactor mediator = new MediatorFactor();
		
		Owner owner = new Owner("Bigmama", mediator);
		Tenant tenant = new Tenant("Kids", mediator);
		
		mediator.setOwner(owner);
		mediator.setTenant(tenant);
		
		owner.constact("You need to pay the rent fee.");
		tenant.constact("Okay, I see!");
	}
}

// Mediator
abstract class MediatorPersion
{
	public abstract void constanct(String message, Persion persion);
}

class MediatorFactor extends MediatorPersion
{
	private Owner owner;
	private Tenant tenant;

	@Override
	public void constanct(String message, Persion persion)
	{
		if (persion == owner)
		{
			tenant.getMessage(message);
		}
		else if (persion == tenant)
		{
			owner.getMessage(message);
		}
	}

	public Owner getOwner()
	{
		return owner;
	}

	public void setOwner(Owner owner)
	{
		this.owner = owner;
	}

	public Tenant getTenant()
	{
		return tenant;
	}

	public void setTenant(Tenant tenant)
	{
		this.tenant = tenant;
	}
}

// Persion
abstract class Persion
{
	protected String name;
	protected MediatorPersion mediator;

	public Persion(String name, MediatorPersion mediator)
	{
		this.name = name;
		this.mediator = mediator;
	}
}

class Owner extends Persion
{
	public Owner(String name, MediatorPersion mediator)
	{
		super(name, mediator);
	}
	
	public void constact(String message)
	{
		mediator.constanct(message, this);
	}
	
	public void getMessage(String message)
	{
		System.out.println("Owner : " + name + ", the obtained message : " + message);
	}
}

class Tenant extends Persion
{
	public Tenant(String name, MediatorPersion mediator)
	{
		super(name, mediator);
	}

	public void constact(String message)
	{
		mediator.constanct(message, this);
	}

	public void getMessage(String message)
	{
		System.out.println("Tenant : " + name + ", the obtained message : " + message);
	}
}
