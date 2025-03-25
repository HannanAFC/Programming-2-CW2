import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Shop Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);

        JLabel taskLabel = new JLabel("Product");
        JTextField taskField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton removeButton = new JButton("Remove");

        // Create a list to display products
        DefaultListModel<String> productListModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productListModel);
        JScrollPane taskPanel = new JScrollPane(productList);

        taskPanel.setPreferredSize(new Dimension(200, 100));

        panel.add(taskLabel);
        panel.add(taskField);
        panel.add(addButton);
        panel.add(Box.createRigidArea(new Dimension(20, 20)));
        panel.add(updateButton);
        panel.add(Box.createRigidArea(new Dimension(20, 20)));
        panel.add(removeButton);
        panel.add(taskPanel);

        // Constraints for taskLabel
        layout.putConstraint(SpringLayout.WEST, taskLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, taskLabel, 10, SpringLayout.NORTH, panel);

        // Constraints for taskField
        layout.putConstraint(SpringLayout.WEST, taskField, 10, SpringLayout.EAST, taskLabel);
        layout.putConstraint(SpringLayout.NORTH, taskField, 10, SpringLayout.NORTH, panel);

        // Constraints for addButton
        layout.putConstraint(SpringLayout.WEST, addButton, 10, SpringLayout.EAST, taskField);
        layout.putConstraint(SpringLayout.NORTH, addButton, 10, SpringLayout.NORTH, panel);
        // Constraints for updateButton
        layout.putConstraint(SpringLayout.WEST, updateButton, 10, SpringLayout.EAST, taskField);
        layout.putConstraint(SpringLayout.NORTH, updateButton, 50, SpringLayout.NORTH, panel);
        // Constraints for removeButton
        layout.putConstraint(SpringLayout.WEST, removeButton, 10, SpringLayout.EAST, taskField);
        layout.putConstraint(SpringLayout.NORTH, removeButton, 90, SpringLayout.NORTH, panel);

        // Constraints for taskPanel
        layout.putConstraint(SpringLayout.WEST, taskPanel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, taskPanel, 100, SpringLayout.SOUTH, addButton);
        layout.putConstraint(SpringLayout.EAST, taskPanel, -10, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, taskPanel, -10, SpringLayout.SOUTH, panel);

        // Button Functionality
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = taskField.getText().trim();
                if (!product.isEmpty()) {
                    productListModel.addElement(product);
                    taskField.setText(""); // Clear the input field
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a product name.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                String updatedProduct = taskField.getText().trim();
                if (selectedIndex != -1 && !updatedProduct.isEmpty()) {
                    productListModel.set(selectedIndex, updatedProduct);
                    taskField.setText(""); // Clear the input field
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a product to update and enter a valid name.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    productListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a product to remove.");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
