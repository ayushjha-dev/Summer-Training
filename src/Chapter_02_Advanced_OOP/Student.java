package Chapter_02_Advanced_OOP;
public class Student {
    int studentId;
    String studentName;
    String course;
 
    // Method to display student details
    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Course: " + course);
    }
 
    public static void main(String[] args) {
        // Create an object of the Student class
        Student student1 = new Student();
 
        // Assign values to the object's properties
        student1.studentId = 101;
        student1.studentName = "Rakesh";
        student1.course = "Computer Science";
 
        System.out.println("Details of the first student:");
        student1.displayDetails();
    }
}