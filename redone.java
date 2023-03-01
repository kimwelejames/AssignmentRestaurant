import java.util.ArrayList;
import java.util.Scanner;

public class redone {

    // Define the menu as a list of food and drink items with their prices
    private static ArrayList<String> menuItems = new ArrayList<>();
    private static ArrayList<Double> menuPrices = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize the menu with some items and prices
        menuItems.add("Hamburger");
        menuPrices.add(9.99);
        menuItems.add("Fries");
        menuPrices.add(2.99);
        menuItems.add("Soda");
        menuPrices.add(1.99);

        // Display the menu to the user
        displayMenu();

        // Allow the user to add an item to the menu
        addItem();

        // Allow the user to order food and drink
        order();

        // Calculate the bill for the user
        double bill = calculateBill();
        System.out.println("Your bill is: $" + bill);

        // Allow the user to make payment via mobile money
        makePayment(bill);
    }

    // Method to display the menu to the user
    private static void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i) + " - $" + menuPrices.get(i));
        }
    }

    // Method to add an item and price to the menu
    private static void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to add an item to the menu? (Y/N): ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.print("Enter the item name: ");
            String item = scanner.nextLine();
            System.out.print("Enter the item price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume the newline character
            menuItems.add(item);
            menuPrices.add(price);
            System.out.println("Item added to the menu!");
        }
    }

    // Method to allow the user to order food and drink
    private static void order() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to order?");
        String order = scanner.nextLine();
        double total = 0.0;
        while (!order.equalsIgnoreCase("done")) {
            boolean found = false;
            for (int i = 0; i < menuItems.size(); i++) {
                if (order.equalsIgnoreCase(menuItems.get(i))) {
                    total += menuPrices.get(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Sorry, we don't have that item.");
            }
            order = scanner.nextLine();
        }
        System.out.println("Your total is: $" + total);
    }

    // Method to calculate the bill for the user
    private static double calculateBill() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount paid: $");
        double paid = scanner.nextDouble();
        double bill = paid - calculateDiscount(paid); // apply a 10% discount
        return bill;
    }

    // Method to calculate a 10% discount on the bill
    private static double calculateDiscount(double amount) {
        return amount * 0.1;
    }

    // Method to allow the user to make payment via mobile money
    private static void makePayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your mobile money number: ");
        String mobileMoneynumber = scanner.nextLine();
        System.out.println("Total amount: ");
    }
}
