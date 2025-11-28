package Chapter_02_Advanced_OOP;
class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
}
 
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog says: bow wow");
    }
}
 
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat says: meow");
    }
}
 
public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();
 
        myAnimal.makeSound();
        myDog.makeSound();
        myCat.makeSound();
    }
}
