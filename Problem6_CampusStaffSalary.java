import java.util.Scanner;

public class Problem6_CampusStaffSalary {
    static class Staff {
        String name;
        double baseSalary;
        Staff(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }
        double getBonus() { return 0; }
        String getType() { return "Staff"; }
        double getTotal() { return baseSalary + getBonus(); }
    }

    static class Teacher extends Staff {
        Teacher(String name, double salary) { super(name, salary); }
        double getBonus() { return 5000; }
        String getType() { return "Teacher"; }
    }

    static class LabAssistant extends Staff {
        LabAssistant(String name, double salary) { super(name, salary); }
        double getBonus() { return 2000; }
        String getType() { return "LabAssistant"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next(), name = sc.next();
            double salary = sc.nextDouble();
            if (type.equalsIgnoreCase("Teacher")) staff[i] = new Teacher(name, salary);
            else if (type.equalsIgnoreCase("LabAssistant")) staff[i] = new LabAssistant(name, salary);
            else staff[i] = new Staff(name, salary);
        }

        double grandTotal = 0;
        for (Staff s : staff) {
            System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                s.name, s.getType(), s.baseSalary, s.getBonus(), s.getTotal());
            grandTotal += s.getTotal();
        }
        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
    }
}
// Printing all staff: O(n) time and O(1) extra space (excluding the array).
