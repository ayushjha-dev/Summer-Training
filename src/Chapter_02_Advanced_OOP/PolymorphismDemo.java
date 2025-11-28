package Chapter_02_Advanced_OOP;
class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}
 
// Polygon.java
class Polygon extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a polygon");
    }
}
 
// Square.java
class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}
 
// PolymorphismDemo.java
public class PolymorphismDemo {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        Shape s2 = new Polygon();
        Shape s3 = new Square();
 
        s1.draw();
        s2.draw();
        s3.draw();
    }
}