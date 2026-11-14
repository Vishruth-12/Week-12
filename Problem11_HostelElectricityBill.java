import java.util.Scanner;

public class Problem11_HostelElectricityBill {
    static long bill(int units) {
        if (units <= 100) return units * 3L + 50;
        if (units <= 200) return 100 * 3L + (units - 100) * 5L + 50;
        return 100 * 3L + 100 * 5L + (units - 200) * 8L + 50;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), billed = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            String room = sc.next();
            int units = sc.nextInt();
            if (units < 0) {
                System.out.println(room + ": invalid reading");
            } else {
                long amount = bill(units);
                System.out.println(room + ": " + units + " units, bill " + amount);
                total += amount;
                billed++;
            }
        }
        System.out.println("Rooms billed " + billed + ", total " + total);
    }
}
// Billing all rooms: O(n) time and O(1) extra space.
