import java.util.Scanner;

public class Problem9_PaymentProcessing {
    interface PaymentMode {
        double processPayment(double amount);
        double getFee(double amount);
        String getMode();
    }

    static class CashPayment implements PaymentMode {
        public double processPayment(double amount) { return amount; }
        public double getFee(double amount) { return 0; }
        public String getMode() { return "Cash"; }
    }

    static class CardPayment implements PaymentMode {
        public double processPayment(double amount) { return amount * 1.02; }
        public double getFee(double amount) { return amount * 0.02; }
        public String getMode() { return "Card"; }
    }

    static class UpiPayment implements PaymentMode {
        public double processPayment(double amount) { return amount; }
        public double getFee(double amount) { return 0; }
        public String getMode() { return "UPI"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            amounts[i] = sc.nextDouble();
            if (mode.equalsIgnoreCase("Card")) payments[i] = new CardPayment();
            else if (mode.equalsIgnoreCase("UPI")) payments[i] = new UpiPayment();
            else payments[i] = new CashPayment();
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            PaymentMode p = payments[i];
            double amount = amounts[i], fee = p.getFee(amount);
            double processed = p.processPayment(amount);
            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                p.getMode(), amount, fee, processed);
            total += processed;
        }
        System.out.printf("Total Amount Processed: %.1f%n", total);
    }
}
// All payments: O(n) time and O(1) extra processing space (excluding arrays).
