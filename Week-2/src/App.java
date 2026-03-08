import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Product laptop, smartphone, headphones;
    
    public static void main(String[] args) {
        laptop = new Product("P001", "Gaming Laptop", 1500.0, 10, "Electronics");
        smartphone = new Product("P002", "Smartphone", 800.0, 15, "Electronics");
        headphones = new Product("P003", "Television", 500.0, 25, "Electronics");
        
        System.out.println("=== WELCOME TO ONLINE SHOP SYSTEM ===\n");
        
        interactiveMode();
        
        System.out.println("\nThank you for using Online Shop System!");
        scanner.close();
    }
    
    // Method to check and display availability
    private static void checkAndDisplayAvailability(Product product, int quantity) {
        if (product.checkAvailability(quantity)) {
            System.out.println(product.getProductName() + ": " + quantity + " items available ✓");
        } else {
            System.out.println(product.getProductName() + ": Only " + product.getStock() + " items available (requested: " + quantity + ") ✗");
        }
    }
    
    // Interactive mode method
    private static void interactiveMode() {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Display all products");
            System.out.println("2. Add stock");
            System.out.println("3. Sell product");
            System.out.println("4. Apply discount");
            System.out.println("5. Check availability");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            if (choice == 6) {
                break;
            }
            
            switch (choice) {
                case 1:
                    laptop.displayDetails();
                    smartphone.displayDetails();
                    headphones.displayDetails();
                    break;
                    
                case 2:
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    Product foundProduct = findProduct(id);
                    if (foundProduct != null) {
                        System.out.print("Enter quantity to add: ");
                        int quantity = scanner.nextInt();
                        foundProduct.addStock(quantity);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Product ID: ");
                    id = scanner.nextLine();
                    foundProduct = findProduct(id);
                    if (foundProduct != null) {
                        System.out.print("Enter quantity to sell: ");
                        int quantity = scanner.nextInt();
                        foundProduct.sellProduct(quantity);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Product ID: ");
                    id = scanner.nextLine();
                    foundProduct = findProduct(id);
                    if (foundProduct != null) {
                        System.out.print("Enter discount percentage: ");
                        int discount = scanner.nextInt();
                        foundProduct.applyDiscount(discount);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter Product ID: ");
                    id = scanner.nextLine();
                    foundProduct = findProduct(id);
                    if (foundProduct != null) {
                        System.out.print("Enter quantity to check: ");
                        int quantity = scanner.nextInt();
                        checkAndDisplayAvailability(foundProduct, quantity);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
    // Method to find product by ID
    private static Product findProduct(String id) {
        if (laptop.getProductId().equals(id)) return laptop;
        if (smartphone.getProductId().equals(id)) return smartphone;
        if (headphones.getProductId().equals(id)) return headphones;
        return null;
    }
}