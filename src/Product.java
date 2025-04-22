class Product {
    private String name;
    private int quantity;
    private double price;
    private int initialQuantity;

    public Product(String name, int quantity, double price, int initialQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.initialQuantity = quantity;
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
    public int getStockSold() {
        return initialQuantity - quantity;
    }
    @Override
    public String toString() {
        //Logic to check stock level and return status of the stock
        String stock;
        switch (quantity) {
            case 0:
                stock = " (𝗢𝗨𝗧 𝗢𝗙 𝗦𝗧𝗢𝗖𝗞!)";
                break;
            case 1, 2, 3, 4:
                stock = " (𝗟𝗼𝘄 𝗦𝘁𝗼𝗰𝗸)";
                break;
            default:
                stock = " (𝗜𝗻 𝘀𝘁𝗼𝗰𝗸)";

        }
        return name + " | " + stock + " | Quantity: " + quantity + " | Price: £" + price + " | Stock sold: " + getStockSold() + " units ";
    }

    public String saleAmount() {
        return name + " | " + quantity + " | Stock sold: £" + getStockSold() * price;
    }
}