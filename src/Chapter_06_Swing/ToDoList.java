package Chapter_06_Swing;
import javax.swing.*;
import java.awt.*;

public class ToDoList extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField textField;

    public ToDoList() {
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        textField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton editButton = new JButton("Edit");

        addButton.addActionListener(e -> {
            String text = textField.getText().trim();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                textField.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int selected = list.getSelectedIndex();
            if (selected != -1) {
                listModel.remove(selected);
            }
        });

        editButton.addActionListener(e -> {
            int selected = list.getSelectedIndex();
            String text = textField.getText().trim();
            if (selected != -1 && !text.isEmpty()) {
                listModel.set(selected, text);
                textField.setText("");
            }
        });

        add(new JScrollPane(list), BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(addButton);
        panel.add(editButton);
        panel.add(removeButton);
        add(panel, BorderLayout.SOUTH);

        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoList();
    }
}
