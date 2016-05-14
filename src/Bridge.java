public class Bridge
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        PhyEngine phy2_3 = new PhyEngine2_3();
        PhyEngine phy2_4 = new PhyEngine2_4();

        AngryAnimals angryDog2_3 = new AngryDog(phy2_3);
        AngryAnimals angryDog2_4 = new AngryDog(phy2_4);
        AngryAnimals angryBird2_3 = new AngryBird(phy2_3);

        angryDog2_3.play();
        angryDog2_4.play();
        angryBird2_3.play();
    }
}

// Abstract
abstract class AngryAnimals
{
    PhyEngine phyEngine;

    public AngryAnimals(PhyEngine phyEngine)
    {
        this.phyEngine = phyEngine;
    }

    abstract public void play();
}

// Concreate
class AngryDog extends AngryAnimals
{
    public AngryDog(PhyEngine phyEngine)
    {
        super(phyEngine);
    }

    public void play()
    {
        System.out.println("AngryDog collide with blocks using " + phyEngine.collide());
    }
}

class AngryBird extends AngryAnimals
{
    public AngryBird(PhyEngine phyEngine)
    {
        super(phyEngine);
    }

    public void play()
    {
        System.out.println("AngryBird collide with blocks using " + phyEngine.collide());
    }
}

// Interface
interface PhyEngine
{
    public String collide();
}

// Refined Abstraction
class PhyEngine2_3 implements PhyEngine
{
    public String collide()
    {
        return "CollideVersion2_3";
    }
}

class PhyEngine2_4 implements PhyEngine
{
    public String collide()
    {
        return "CollideVersion2_4";
    }
}