import java.util.Scanner;

public class Problem10_WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rain = new double[7];
        double total = 0;
        int wettest = 0, dryDays = 0;

        for (int i = 0; i < 7; i++) {
            rain[i] = sc.nextDouble();
            total += rain[i];
            if (rain[i] > rain[wettest] || i == 0) wettest = i;
            if (rain[i] == 0) dryDays++;
        }

        System.out.print("Rainfall (mm): ");
        for (double x : rain) System.out.print(x + " ");
        System.out.printf("%nTotal Rainfall: %.1f mm%n", total);
        System.out.printf("Average Rainfall: %.2f mm%n", total / 7);
        System.out.printf("Wettest Day: Day %d (%.1f mm)%n", wettest + 1, rain[wettest]);
        System.out.println("Total Dry Days: " + dryDays);
    }
}
// Time: O(7) = O(1); space: O(7) = O(1), since the week has seven days.
