public class Product {
    // Attributes
    private String productId;
    private String productName;
    private double price;
    private int stock;
    private String category;
    private double discount;
    
    // Constructor
    public Product(String productId, String productName, double price, int stock, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.discount = 0.0;
    }
    
    // Method to add stock
    public void addStock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
            System.out.println(quantity + " items added to stock. Current stock: " + stock);
        } else {
            System.out.println("Invalid quantity!");
        }
    }
    
    // Method to sell product (reduce stock)
    public void sellProduct(int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
        } else if (quantity <= stock) {
            stock -= quantity;
            double totalPrice = calculatePriceAfterDiscount() * quantity;
            System.out.println(quantity + " " + productName + " sold. Total price: $" + totalPrice);
            System.out.println("Remaining stock: " + stock);
        } else {
            System.out.println("Insufficient stock! Available stock: " + stock);
        }
    }
    
    // Method to display product details
    public void displayDetails() {
        System.out.println("\n=== Product Details ===");
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        if (discount > 0) {
            System.out.println("Discount: " + (discount * 100) + "%");
            System.out.println("Price after discount: $" + calculatePriceAfterDiscount());
        }
        System.out.println("Stock: " + stock);
        System.out.println("Category: " + category);
        System.out.println("=======================\n");
    }
    
    // Method to apply discount
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            this.discount = discountPercentage / 100;
            System.out.println("Discount of " + discountPercentage + "% applied to " + productName);
        } else {
            System.out.println("Invalid discount percentage!");
        }
    }
    
    // Method to check stock availability
    public boolean checkAvailability(int requestedQuantity) {
        return stock >= requestedQuantity;
    }
    
    // Method to calculate price after discount
    private double calculatePriceAfterDiscount() {
        return price * (1 - discount);
    }
    
    // Getter methods
    public String getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getDiscount() {
        return discount * 100;
    }
}
