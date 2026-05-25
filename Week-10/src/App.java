import java.io.*;
import java.util.*;


public class App {

    private static final String FILE_PATH = "phone.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeFile();

        System.out.println("PHONE BOOK APP");
        

        boolean running = true;
        while (running) {
            showMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": addContact(scanner);
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    searchContact(scanner);
                    break;
                case "4":
                    deleteContact(scanner);
                    break;
                case "5":
                    System.out.println("\nThank you for using the Phone Book App.");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid option. Please choose 1-5.\n");
            }
        }

        scanner.close();
    }

    
    private static void showMenu() {
        System.out.println("MENU");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit");
    }

    // FEATURE 1 — ADD CONTACT
    private static void addContact(Scanner scanner) {
        System.out.println("\n── Add New Contact ──");

        // Collect name
        System.out.print("Enter name        : ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        // Collect phone number 
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        if (!isValidPhone(phone)) {
            System.out.println("Invalid phone number. Use digits only (7–12 characters).");
            return;
        }
  
        if (phoneExists(phone)) {
            System.out.println("⚠  A contact with that phone number already exists.");
            return;
        }

        // Append the new contact to phone.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(name + " - " + phone);
            writer.newLine();
            System.out.println("Contact saved: " + name + " - " + phone);
        } catch (IOException e) {
            System.out.println("Error saving contact: " + e.getMessage());
        }
    }


    // FEATURE 2 — VIEW ALL CONTACTS
    private static void viewContacts() {
        System.out.println("\n── All Contacts ──");

        List<String> contacts = readAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("  (No contacts found)");
            return;
        }

        // Print header
        System.out.printf("  %-4s %-25s %-20s%n", "No.", "Name", "Phone Number");
        System.out.println("  " + "─".repeat(51));

        // Print each contact with a sequential number
        int index = 1;
        for (String line : contacts) {
            String[] parts = parseLine(line);
            if (parts != null) {
                System.out.printf("  %-4d %-25s %-20s%n", index++, parts[0], parts[1]);
            }
        }
        System.out.println("  " + "─".repeat(51));
        System.out.println("  Total: " + (index - 1) + " contact(s)");
    }


    // FEATURE 3 — SEARCH CONTACT
    private static void searchContact(Scanner scanner) {
        System.out.println("\n── Search Contact ──");
        System.out.print("Enter name or phone to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        if (keyword.isEmpty()) {
            System.out.println("⚠  Search keyword cannot be empty.");
            return;
        }

        List<String> contacts = readAllContacts();
        List<String> results  = new ArrayList<>();

        // Collect all lines that contain the keyword in name or phone
        for (String line : contacts) {
            if (line.toLowerCase().contains(keyword)) {
                results.add(line);
            }
        }

        if (results.isEmpty()) {
            System.out.println("  No contacts found matching \"" + keyword + "\".");
            return;
        }

        System.out.println("  Found " + results.size() + " result(s):");
        System.out.printf("  %-4s %-25s %-20s%n", "No.", "Name", "Phone Number");
        System.out.println("  " + "─".repeat(51));

        int index = 1;
        for (String line : results) {
            String[] parts = parseLine(line);
            if (parts != null) {
                System.out.printf("  %-4d %-25s %-20s%n", index++, parts[0], parts[1]);
            }
        }
    }

   
    // FEATURE 4 — DELETE CONTACT
    private static void deleteContact(Scanner scanner) {
        System.out.println("\n── Delete Contact ──");

        List<String> contacts = readAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("  (No contacts to delete)");
            return;
        }

        // Show numbered list so user can pick
        System.out.printf("  %-4s %-25s %-20s%n", "No.", "Name", "Phone Number");
        System.out.println("  " + "─".repeat(51));
        int index = 1;
        for (String line : contacts) {
            String[] parts = parseLine(line);
            if (parts != null) {
                System.out.printf("  %-4d %-25s %-20s%n", index++, parts[0], parts[1]);
            }
        }

        System.out.print("\nEnter the number of the contact to delete (0 to cancel): ");
        String input = scanner.nextLine().trim();

        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("⚠  Invalid input. Please enter a number.");
            return;
        }

        if (choice == 0) {
            System.out.println("  Deletion cancelled.");
            return;
        }

        if (choice < 1 || choice > contacts.size()) {
            System.out.println("⚠  Number out of range.");
            return;
        }

        // Remove the selected contact (list is 0-indexed)
        String removed = contacts.remove(choice - 1);

        // Rewrite phone.txt with the remaining contacts
        writeAllContacts(contacts);

        String[] parts = parseLine(removed);
        String label = (parts != null) ? parts[0] + " - " + parts[1] : removed;
        System.out.println("✔  Deleted: " + label);
    }


    // HELPER METHODS
    private static void initializeFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("ℹ  Created new file: " + FILE_PATH);
                }
            } catch (IOException e) {
                System.out.println("✘  Could not create " + FILE_PATH + ": " + e.getMessage());
            }
        }
    }

   
    private static List<String> readAllContacts() {
        List<String> contacts = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) return contacts;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {      // skip blank lines
                    contacts.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("✘  Error reading file: " + e.getMessage());
        }

        return contacts;
    }

    private static void writeAllContacts(List<String> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (String line : contacts) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    private static String[] parseLine(String line) {
        // Split on the first occurrence of " - "
        int sep = line.indexOf(" - ");
        if (sep == -1) return null;
        String name  = line.substring(0, sep).trim();
        String phone = line.substring(sep + 3).trim();
        return new String[]{name, phone};
    }

    private static boolean isValidPhone(String phone) {
        return phone.matches("\\d{7,15}");
    }


    private static boolean phoneExists(String phone) {
        for (String line : readAllContacts()) {
            String[] parts = parseLine(line);
            if (parts != null && parts[1].equals(phone)) {
                return true;
            }
        }
        return false;
    }
}