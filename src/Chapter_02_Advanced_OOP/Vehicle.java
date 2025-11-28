package Chapter_02_Advanced_OOP;
class Vehicle {
    String brand;
 
    public void honk() {
        System.out.println("Tuut, tuut!");
    }
}
 
// Car.java
class Car extends Vehicle {
    String modelName;
 
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + modelName);
    }
 
    public static void main(String[] args) {
        Car myCar = new Car();
 
        myCar.brand = "Ford";
        myCar.modelName = "Mustang";
 
        myCar.honk();
        myCar.display();
    }
}