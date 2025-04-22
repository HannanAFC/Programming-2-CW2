class Product {
    private final String name;
    private int quantity;
    private final double price;
    private final int initialQuantity;

    public Product(String name, int quantity, double price, int initialQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.initialQuantity = initialQuantity;
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

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public int getStockSold() {
        return getInitialQuantity() - getQuantity();
    }
    @Override
    public String toString() {
        //Logic to check stock level and return status of the stock
        String stock = switch (quantity) {
            case 0 -> " (𝗢𝗨𝗧 𝗢𝗙 𝗦𝗧𝗢𝗖𝗞!)";
            case 1, 2, 3, 4 -> " (𝗟𝗼𝘄 𝗦𝘁𝗼𝗰𝗸)";
            default -> " (𝗜𝗻 𝘀𝘁𝗼𝗰𝗸)";
        };
        return name + " | Current stock:  " + stock + " | Quantity: " + quantity + " | Price: £" + price + " | Stock sold: " + getStockSold() + " units ";
    }

    public String saleAmount() {
        return name + " | " + quantity + " | Stock sold: £" + getStockSold() * price;
    }
}