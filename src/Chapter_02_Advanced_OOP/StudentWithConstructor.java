package Chapter_02_Advanced_OOP;
public class StudentWithConstructor {
    int studentId;
    String studentName;
    String course;

    // Default constructor
    public StudentWithConstructor() {
        this.studentId = 0;
        this.studentName = "Unknown";
        this.course = "Not Enrolled";
    }

    // Parameterized constructor
    public StudentWithConstructor(int id, String name, String courseName) {
        this.studentId = id;
        this.studentName = name;
        this.course = courseName;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Course: " + course);
    }

    public static void main(String[] args) {
        StudentWithConstructor student1 = new StudentWithConstructor();
        System.out.println("Details of student 1 (default constructor):");
        student1.displayDetails();
        System.out.println();

        StudentWithConstructor student2 = new StudentWithConstructor(102, "Jane Smith", "Information Technology");
        System.out.println("Details of student 2 (parameterized constructor):");
        student2.displayDetails();
    }
}
