import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

// Product class
class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (Qty: " + quantity + ", Price: £" + price + ")";
    }
}

// Main class
public class Main {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static double totalSales = 0;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Shop Management System");

        try {
            String status = readJSON();
            if (status.equals("Inventory read successfully")) {
                System.out.println(status);
            }
            else {
                JOptionPane.showMessageDialog(frame, status);
            }
        }
        catch (FileNotFoundException e ) {
            JOptionPane.showMessageDialog(frame, "File not found and new one was not able to be created");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);

        DefaultListModel<String> productListModel = new DefaultListModel<>();
        for (Product product : inventory) {
            productListModel.addElement(product.toString());
        }
        JList<String> productList = new JList<>(productListModel);
        JScrollPane listScrollPane = new JScrollPane(productList);

        JTextField nameField = new JTextField(10);
        JTextField quantityField = new JTextField(5);
        JTextField priceField = new JTextField(5);

        JButton addButton = new JButton("Add Product");
        JButton sellButton = new JButton("Sell Product");
        JButton reportButton = new JButton("Generate Report");

        JLabel nameLabel = new JLabel("Name:");
        JLabel quantityLabel = new JLabel("Quantity:");
        JLabel priceLabel = new JLabel("Price:");

        // Add constraints for layout
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, quantityLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, quantityLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, quantityField, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, quantityField, 40, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, priceLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, priceLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, priceField, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, priceField, 70, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addButton, 250, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addButton, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sellButton, 250, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sellButton, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, reportButton, 250, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, reportButton, 70, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, listScrollPane, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, listScrollPane, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, listScrollPane, -10, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, listScrollPane, -10, SpringLayout.SOUTH, panel);

        // Add components to panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(addButton);
        panel.add(sellButton);
        panel.add(reportButton);
        panel.add(listScrollPane);

        frame.add(panel);
        frame.setVisible(true);

        // Add button functionality (reuse from original code)
        addButton.addActionListener(c -> {
            try {
                String name = nameField.getText().trim();
                int quantity = Integer.parseInt(quantityField.getText().trim());
                double price = Double.parseDouble(priceField.getText().trim());

                if (!name.isEmpty() && quantity > 0 && price > 0) {
                    Product product = new Product(name, quantity, price);
                    inventory.add(product);
                    productListModel.addElement(product.toString());
                    nameField.setText("");
                    quantityField.setText("");
                    priceField.setText("");
                    String writeStatus = writeJSON();
                    if (!writeStatus.equals("Inventory written successfully")) {
                        JOptionPane.showMessageDialog(frame, writeStatus);
                    }
                    System.out.println(writeStatus);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid product details.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for quantity and price.");
            }
        });

        sellButton.addActionListener(c -> {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                Product selectedProduct = inventory.get(selectedIndex);
                String input = JOptionPane.showInputDialog("Enter quantity to sell:");
                try {
                    int sellQuantity = Integer.parseInt(input.trim());
                    if (sellQuantity > 0 && sellQuantity <= selectedProduct.getQuantity()) {
                        selectedProduct.setQuantity(selectedProduct.getQuantity() - sellQuantity);
                        totalSales += sellQuantity * selectedProduct.getPrice();
                        if (selectedProduct.getQuantity() == 0) {
                            inventory.remove(selectedIndex);
                            productListModel.remove(selectedIndex);
                            String writeStatus = writeJSON();
                            if (!writeStatus.equals("Inventory written successfully")) {
                                JOptionPane.showMessageDialog(frame, writeStatus);
                            }
                            System.out.println(writeStatus);
                        } else {
                            productListModel.set(selectedIndex, selectedProduct.toString());
                            String writeStatus;
                            writeStatus = writeJSON();
                            if (!writeStatus.equals("Inventory written successfully")) {
                                JOptionPane.showMessageDialog(frame, writeStatus);
                            }
                            System.out.println(writeStatus);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid quantity.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a product to sell.");
            }
        });

        reportButton.addActionListener(c -> {
            StringBuilder report = new StringBuilder();
            report.append("Sales Summary:\nTotal Sales: £").append(totalSales).append("\n\n");
            report.append("Low Stock Items:\n");
            for (Product product : inventory) {
                if (product.getQuantity() <= 5) {
                    report.append(product).append("\n");
                }
            }
            JOptionPane.showMessageDialog(frame, report.toString());
        });
    }

    public static String writeJSON() {
        //creates a gson object, uses it to turn tasks array into a json string, then writes it to the file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(inventory);
        try {
            FileWriter writer = new FileWriter("inventory.json");
            writer.write(json);
            writer.close();
        }
        catch (IOException e) {
            return "Error writing to file";
        }
        return "Inventory written successfully";
    }

    public static String readJSON() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("inventory.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                String error = "Error creating file";
            }
            String error = "Warning - File not found, new file created.";
            return error;
        }
        BufferedReader reader = new BufferedReader(new FileReader("inventory.json"));

        //defines the type of data that will be read
        Type listType = new TypeToken<ArrayList<Product>>() {}.getType();

        /*
        the tasks are read and added to an arraylist, this is then added to the empty tasks arraylist
        error handling in case the file is empty
        */
        try {
            ArrayList<Product> readTasks = gson.fromJson(reader, listType);
            inventory.addAll(readTasks);
        }
        catch (NullPointerException e) {
            return "Warning - File was empty.";
        }
        return "Inventory read successfully";
    }

}
