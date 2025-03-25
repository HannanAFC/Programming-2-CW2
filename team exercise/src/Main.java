import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a rectangle
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 60); // x, y, width, height

        // Draw an oval
        g.setColor(Color.BLUE);
        g.fillOval(200, 50, 100, 60); // x, y, width, height

        // Draw a line
        g.setColor(Color.GREEN);
        g.drawLine(50, 150, 300, 150); // x1, y1, x2, y2
    }

    public static void main(String[] args) {
        // Create a JFrame to hold the panel
        JFrame frame = new JFrame("Shape Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Add an instance of the ShapeDrawer class
        Main shapePanel = new Main();
        frame.add(shapePanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
