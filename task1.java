import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Exchange rates (Base: USD)
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("INR", 83.0);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.78);
        rates.put("JPY", 150.0);

        // Currency symbols
        Map<String, String> symbols = new HashMap<>();
        symbols.put("USD", "$");
        symbols.put("INR", "₹");
        symbols.put("EUR", "€");
        symbols.put("GBP", "£");
        symbols.put("JPY", "¥");

        while (true) {
            System.out.println("\n===== Currency Converter =====");
            System.out.println("Available currencies: USD, INR, EUR, GBP, JPY");
            System.out.println("1. Convert Currency");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Thank you for using Currency Converter!");
                break;
            }

            // Input currencies
            System.out.print("Enter base currency: ");
            String base = sc.next().toUpperCase();

            System.out.print("Enter target currency: ");
            String target = sc.next().toUpperCase();

            // Validate currency
            if (!rates.containsKey(base) || !rates.containsKey(target)) {
                System.out.println(" Invalid currency! Try again.");
                continue;
            }

            // Input amount
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println(" Enter a valid amount!");
                continue;
            }

            // Conversion logic
            double usdAmount = amount / rates.get(base);
            double convertedAmount = usdAmount * rates.get(target);

            // Display result
            System.out.printf(" Converted Amount: %s %.2f\n",
                    symbols.get(target), convertedAmount);
        }

        sc.close();
    }
}
