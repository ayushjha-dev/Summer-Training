package Chapter_02_Advanced_OOP;
interface Drawable {
    void draw();
}
 
// Rectangle.java
class Rectangle implements Drawable {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
 
// Circle.java
class Circle implements Drawable {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
 
// TestInterface.java
public class TestInterface {
    public static void main(String[] args) {
        Drawable rect = new Rectangle();
        Drawable circ = new Circle();
 
        rect.draw();
        circ.draw();
    }
}
