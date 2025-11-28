package Chapter_02_Advanced_OOP;
abstract class AbstractAnimal {
    // Abstract method
    public abstract void animalSound();
 
    public void sleep() {
        System.out.println("Zzz");
    }
}
 
// Pig.java
class Pig extends AbstractAnimal {
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }
}
 
// TestAbstract.java
public class TestAbstract {
    public static void main(String[] args) {
        Pig myPig = new Pig();
        myPig.animalSound();
        myPig.sleep();
    }
}
