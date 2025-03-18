import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Shop Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);

        JLabel taskLabel = new JLabel("Sale");
        JTextField taskField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

        panel.add(taskLabel);
        panel.add(taskField);
        panel.add(addButton);
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

        // Constraints for taskPanel
        layout.putConstraint(SpringLayout.WEST, taskPanel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, taskPanel, 10, SpringLayout.SOUTH, addButton);
        layout.putConstraint(SpringLayout.EAST, taskPanel, -10, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, taskPanel, -10, SpringLayout.SOUTH, panel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
