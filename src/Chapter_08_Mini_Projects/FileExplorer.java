package Chapter_08_Mini_Projects;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;
import java.util.Date;

public class FileExplorer extends JFrame {
    private JTree fileTree;
    private JTextField pathField;
    private JPanel fileInfoPanel;
    private JLabel fileInfoLabel;
    
    public FileExplorer() {
        super("Java File Explorer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        
        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Create a panel for the path field
        JPanel pathPanel = new JPanel(new BorderLayout());
        pathField = new JTextField();
        pathField.setEditable(false);
        pathPanel.add(new JLabel(" Path: "), BorderLayout.WEST);
        pathPanel.add(pathField, BorderLayout.CENTER);
        
        // Create the file tree
        fileTree = new JTree(createFileTreeModel());
        fileTree.setCellRenderer(new FileTreeCellRenderer());
        fileTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
                    fileTree.getLastSelectedPathComponent();
                if (node == null) return;
                
                Object nodeInfo = node.getUserObject();
                if (nodeInfo instanceof FileNode) {
                    FileNode fileNode = (FileNode) nodeInfo;
                    File file = fileNode.getFile();
                    pathField.setText(file.getAbsolutePath());
                    updateFileInfo(file);
                }
            }
        });
        
        // Create file info panel
        fileInfoPanel = new JPanel(new BorderLayout());
        fileInfoPanel.setBorder(BorderFactory.createTitledBorder("File Information"));
        fileInfoLabel = new JLabel();
        fileInfoPanel.add(fileInfoLabel, BorderLayout.CENTER);
        
        // Add components to the main panel
        mainPanel.add(pathPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(fileTree), BorderLayout.CENTER);
        mainPanel.add(fileInfoPanel, BorderLayout.SOUTH);
        
        // Set the content pane
        setContentPane(mainPanel);
    }
    
    private TreeModel createFileTreeModel() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(
            new FileNode(new File(System.getProperty("user.home"))));
        
        File[] roots = File.listRoots();
        for (File fileRoot : roots) {
            DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(new FileNode(fileRoot));
            root.add(rootNode);
            
            File[] files = fileRoot.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        DefaultMutableTreeNode dirNode = new DefaultMutableTreeNode(new FileNode(file));
                        rootNode.add(dirNode);
                        addChildren(dirNode, file, 1); // Limit depth to 1 for performance
                    }
                }
            }
        }
        
        return new DefaultTreeModel(root);
    }
    
    private void addChildren(DefaultMutableTreeNode node, File dir, int depth) {
        if (depth > 2) return; // Limit depth to prevent performance issues
        
        File[] files = dir.listFiles();
        if (files == null) return;
        
        for (File file : files) {
            if (file.isDirectory()) {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new FileNode(file));
                node.add(childNode);
                if (depth < 2) {
                    addChildren(childNode, file, depth + 1);
                }
            }
        }
    }
    
    private void updateFileInfo(File file) {
        StringBuilder info = new StringBuilder("<html>");
        info.append("Name: ").append(file.getName()).append("<br>");
        info.append("Path: ").append(file.getAbsolutePath()).append("<br>");
        info.append("Size: ").append(file.isDirectory() ? "-" : file.length() + " bytes").append("<br>");
        info.append("Last Modified: ").append(new Date(file.lastModified())).append("<br>");
        info.append("Type: ").append(file.isDirectory() ? "Directory" : "File").append("<br>");
        info.append("Hidden: ").append(file.isHidden()).append("<br>");
        info.append("</html>");
        
        fileInfoLabel.setText(info.toString());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileExplorer().setVisible(true);
            }
        });
    }
    
    // Custom file node class
    class FileNode {
        private File file;
        
        public FileNode(File file) {
            this.file = file;
        }
        
        public File getFile() {
            return file;
        }
        
        @Override
        public String toString() {
            return file.getName().length() > 0 ? file.getName() : file.getPath();
        }
    }
    
    // Custom cell renderer for the file tree
    class FileTreeCellRenderer extends DefaultTreeCellRenderer {
        private Icon folderIcon = UIManager.getIcon("FileView.directoryIcon");
        private Icon fileIcon = UIManager.getIcon("FileView.fileIcon");
        
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, 
                boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            
            super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userObject = node.getUserObject();
            
            if (userObject instanceof FileNode) {
                FileNode fileNode = (FileNode) userObject;
                File file = fileNode.getFile();
                
                if (file.isDirectory()) {
                    setIcon(folderIcon);
                } else {
                    setIcon(fileIcon);
                }
            }
            
            return this;
        }
    }
}
