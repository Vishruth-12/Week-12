import java.util.Scanner;

public class Problem8_LibraryReturnDesk {
    static class Desk {
        String[] pile = new String[3], line = new String[3];
        int top = -1, front = 0, rear = -1, size = 0;

        void command(String input) {
            String[] p = input.trim().split("\\s+", 2);
            String op = p[0].toUpperCase();
            String value = p.length > 1 ? p[1] : "";

            switch (op) {
                case "RETURN":
                    if (top == 2) System.out.println(value + " rejected: pile is full");
                    else {
                        pile[++top] = value;
                        System.out.println(value + " placed on pile");
                    }
                    break;
                case "SHELVE":
                    if (top == -1) System.out.println("pile is empty");
                    else System.out.println("shelved " + pile[top--]);
                    break;
                case "WAIT":
                    if (size == 3) System.out.println(value + " rejected: line is full");
                    else {
                        rear = (rear + 1) % 3;
                        line[rear] = value;
                        size++;
                        System.out.println(value + " joined the line");
                    }
                    break;
                case "SERVE":
                    if (size == 0) System.out.println("no one waiting");
                    else {
                        System.out.println("served " + line[front]);
                        line[front] = null;
                        front = (front + 1) % 3;
                        size--;
                        if (size == 0) rear = (front + 2) % 3;
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Desk d = new Desk();
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) d.command(sc.nextLine());
    }
}
// RETURN, SHELVE, WAIT and SERVE: O(1) each.
