import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] items = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] prices = {80, 120, 100, 70, 90};

        int totalItems = 0;
        double totalBefore = 0, totalDiscount = 0;
        String again;

        System.out.println("=====  M E N U  =====");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-12s - $%.2f%n", i + 1, items[i], prices[i]);
        }

        do {
            System.out.print("\nEnter item number: ");
            int choice = sc.nextInt();
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            if (choice < 1 || choice > items.length || qty <= 0) {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
            } else {
                System.out.print("Are you a student? (Y/N): ");
                String student = sc.nextLine().trim();

                double subtotal = prices[choice - 1] * qty;
                double rate = 0;
                if (student.equalsIgnoreCase("Y")) {
                    rate = 0.10;              // student discount
                    if (qty >= 5) rate = 0.15; // bulk bonus
                }
                double discount = subtotal * rate;
                double total = subtotal - discount;

                System.out.printf("%nSubtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discount);
                System.out.printf("Order total: $%.2f%n", total);

                totalItems += qty;
                totalBefore += subtotal;
                totalDiscount += discount;
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            again = sc.nextLine().trim();
        } while (again.equalsIgnoreCase("Y"));

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalBefore);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", totalBefore - totalDiscount);
        System.out.println("Thank you for ordering!");

        sc.close();
    }
}