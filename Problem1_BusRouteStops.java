import java.util.Scanner;

public class Problem1_BusRouteStops {
    static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

    static Node build(String[] stops) {
        Node head = null, tail = null;
        for (String stop : stops) {
            Node p = new Node(stop);
            if (head == null) head = p;
            else tail.next = p;
            tail = p;
        }
        return head;
    }

    static void printRoute(Node head) {
        Node p = head;
        int count = 0;
        String first = null, last = null;
        while (p != null) {
            if (count == 0) first = p.data;
            last = p.data;
            System.out.print(p.data + " -> ");
            count++;
            p = p.next;
        }
        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) stops[i] = sc.next();
        printRoute(build(stops));
    }
}
// Build: O(n). Print and count: O(n). Extra space for the chain: O(n).
