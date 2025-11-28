package Chapter_08_Mini_Projects.StudentManagementSystem;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * StudentManagementSystem - A simple GUI application for managing student records
 */
public class StudentManagementSystem extends JFrame {
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JTextField idField, nameField, ageField, courseField, gpaField, searchField;
    private JButton addButton, updateButton, deleteButton, clearButton, searchButton;
    private StudentDAO studentDAO;
    
    public StudentManagementSystem() {
        super("Student Management System");
        studentDAO = new StudentDAO();
        
        setupUI();
        loadStudentData();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
    }
    
    /**
     * Set up the user interface components
     */
    private void setupUI() {
        // Create the main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create form panel for input fields
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));
        
        // ID field
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField(10);
        formPanel.add(idField);
        
        // Name field
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField(30);
        formPanel.add(nameField);
        
        // Age field
        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField(5);
        formPanel.add(ageField);
        
        // Course field
        formPanel.add(new JLabel("Course:"));
        courseField = new JTextField(20);
        formPanel.add(courseField);
        
        // GPA field
        formPanel.add(new JLabel("GPA:"));
        gpaField = new JTextField(5);
        formPanel.add(gpaField);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Add button
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        buttonPanel.add(addButton);
        
        // Update button
        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });
        buttonPanel.add(updateButton);
        
        // Delete button
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
        buttonPanel.add(deleteButton);
        
        // Clear button
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        buttonPanel.add(clearButton);
        
        // Add form and button panels to an input panel
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(formPanel, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add the input panel to the west of the main panel
        mainPanel.add(inputPanel, BorderLayout.WEST);
        
        // Create table model with columns
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Course");
        tableModel.addColumn("GPA");
        
        // Create the table
        studentTable = new JTable(tableModel);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow != -1) {
                    populateFields(selectedRow);
                }
            }
        });
        
        // Add the table to a scroll pane
        JScrollPane tableScrollPane = new JScrollPane(studentTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Student Records"));
        
        // Create search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search by Name:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudents();
            }
        });
        searchPanel.add(searchButton);
        
        JButton showAllButton = new JButton("Show All");
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadStudentData();
            }
        });
        searchPanel.add(showAllButton);
        
        // Add the search panel and table to a panel
        JPanel dataPanel = new JPanel(new BorderLayout(5, 5));
        dataPanel.add(searchPanel, BorderLayout.NORTH);
        dataPanel.add(tableScrollPane, BorderLayout.CENTER);
        
        // Add the data panel to the center of the main panel
        mainPanel.add(dataPanel, BorderLayout.CENTER);
        
        // Status bar at the bottom
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        JLabel statusLabel = new JLabel("Ready");
        statusPanel.add(statusLabel);
        mainPanel.add(statusPanel, BorderLayout.SOUTH);
        
        // Set the content pane
        setContentPane(mainPanel);
    }
    
    /**
     * Load all student data into the table
     */
    private void loadStudentData() {
        // Clear the table
        tableModel.setRowCount(0);
        
        // Get all students and add them to the table
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            Object[] row = {
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getCourse(),
                student.getGpa()
            };
            tableModel.addRow(row);
        }
    }
    
    /**
     * Add a new student based on the input fields
     */
    private void addStudent() {
        try {
            // Get data from input fields
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String course = courseField.getText().trim();
            double gpa = Double.parseDouble(gpaField.getText().trim());
            
            // Validate the data
            if (name.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Name and course cannot be empty", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Create a new student and add it
            Student student = new Student(id, name, age, course, gpa);
            boolean added = studentDAO.addStudent(student);
            
            if (added) {
                JOptionPane.showMessageDialog(this, 
                    "Student added successfully", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                loadStudentData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Student ID already exists", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numeric values for ID, Age, and GPA", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Update an existing student based on the input fields
     */
    private void updateStudent() {
        try {
            // Get data from input fields
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String course = courseField.getText().trim();
            double gpa = Double.parseDouble(gpaField.getText().trim());
            
            // Validate the data
            if (name.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Name and course cannot be empty", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Create a student object and update it
            Student student = new Student(id, name, age, course, gpa);
            boolean updated = studentDAO.updateStudent(student);
            
            if (updated) {
                JOptionPane.showMessageDialog(this, 
                    "Student updated successfully", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                loadStudentData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Student not found", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numeric values for ID, Age, and GPA", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Delete a student based on the ID field
     */
    private void deleteStudent() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            
            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete this student?", 
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                boolean deleted = studentDAO.deleteStudent(id);
                
                if (deleted) {
                    JOptionPane.showMessageDialog(this, 
                        "Student deleted successfully", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadStudentData();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Student not found", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid student ID", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Search for students by name
     */
    private void searchStudents() {
        String searchTerm = searchField.getText().trim();
        
        if (searchTerm.isEmpty()) {
            loadStudentData();
            return;
        }
        
        // Clear the table
        tableModel.setRowCount(0);
        
        // Search for students and add them to the table
        List<Student> students = studentDAO.searchStudentsByName(searchTerm);
        for (Student student : students) {
            Object[] row = {
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getCourse(),
                student.getGpa()
            };
            tableModel.addRow(row);
        }
    }
    
    /**
     * Populate the input fields with data from a selected table row
     */
    private void populateFields(int selectedRow) {
        idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
        nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
        ageField.setText(tableModel.getValueAt(selectedRow, 2).toString());
        courseField.setText(tableModel.getValueAt(selectedRow, 3).toString());
        gpaField.setText(tableModel.getValueAt(selectedRow, 4).toString());
    }
    
    /**
     * Clear all input fields
     */
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseField.setText("");
        gpaField.setText("");
        studentTable.clearSelection();
    }
    
    /**
     * Main method to start the application
     */
    public static void main(String[] args) {
        try {
            // Set the look and feel to the system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementSystem().setVisible(true);
            }
        });
    }
}
