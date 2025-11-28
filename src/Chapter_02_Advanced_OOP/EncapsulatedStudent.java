package Chapter_02_Advanced_OOP;
public class EncapsulatedStudent {
    private int studentId;
    private String studentName;
    private String course;
 
    public int getStudentId() {
        return studentId;
    }
 
    public void setStudentId(int id) {
        if (id > 0) { // Basic validation
            this.studentId = id;
        } else {
            System.out.println("Invalid Student ID.");
        }
    }
 
    public String getStudentName() {
        return studentName;
    }
 
    public void setStudentName(String name) {
        this.studentName = name;
    }
 
    public String getCourse() {
        return course;
    }
 
    public void setCourse(String course) {
        this.course = course;
    }
 
    public static void main(String[] args) {
        EncapsulatedStudent student = new EncapsulatedStudent();
 
        student.setStudentId(103);
        student.setStudentName("Peter Jones");
        student.setCourse("Mechanical Engineering");
 
        System.out.println("Student Details:");
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Name: " + student.getStudentName());
        System.out.println("Course: " + student.getCourse());
        
        System.out.println("\nTrying to set an invalid ID...");
        student.setStudentId(-5);
    }
}
