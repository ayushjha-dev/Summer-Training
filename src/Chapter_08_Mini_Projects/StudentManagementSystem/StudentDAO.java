package Chapter_08_Mini_Projects.StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * StudentDAO (Data Access Object) class for handling data operations
 * This implementation uses a file-based storage system
 */
public class StudentDAO {
    private static final String DATA_FILE = "students.dat";
    private List<Student> students;
    
    public StudentDAO() {
        students = new ArrayList<>();
        loadData();
    }
    
    /**
     * Add a new student to the database
     */
    public boolean addStudent(Student student) {
        // Ensure the ID is unique
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                return false;
            }
        }
        students.add(student);
        saveData();
        return true;
    }
    
    /**
     * Update an existing student's information
     */
    public boolean updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                saveData();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Delete a student by their ID
     */
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                saveData();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get a student by their ID
     */
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
    /**
     * Get all students
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    /**
     * Search for students by name (case-insensitive partial match)
     */
    public List<Student> searchStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        String searchName = name.toLowerCase();
        
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName)) {
                result.add(student);
            }
        }
        
        return result;
    }
    
    /**
     * Save the student data to a file
     */
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DATA_FILE))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error saving student data: " + e.getMessage());
        }
    }
    
    /**
     * Load the student data from a file
     */
    @SuppressWarnings("unchecked")
    private void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            // Create a few sample students if the file doesn't exist
            addSampleData();
            return;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(DATA_FILE))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading student data: " + e.getMessage());
            // Create sample data if there was an error loading
            addSampleData();
        }
    }
    
    /**
     * Add sample data for initial use
     */
    private void addSampleData() {
        students.add(new Student(1001, "John Smith", 20, "Computer Science", 3.8));
        students.add(new Student(1002, "Sarah Johnson", 22, "Mathematics", 3.9));
        students.add(new Student(1003, "Michael Brown", 19, "Physics", 3.5));
        students.add(new Student(1004, "Emma Davis", 21, "Chemistry", 3.7));
        students.add(new Student(1005, "James Wilson", 20, "Engineering", 3.6));
        saveData();
    }
}
