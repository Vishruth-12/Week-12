public class Problem2_LateComersInLine {
    static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

    static Node addFirst(Node head, String name) {
        Node p = new Node(name);
        p.next = head;
        return p;
    }

    static Node addLast(Node head, String name) {
        Node p = new Node(name);
        if (head == null) return p;
        Node q = head;
        while (q.next != null) q = q.next;
        q.next = p;
        return head;
    }

    static void printLine(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;
        head = addLast(head, "Asha");
        head = addLast(head, "Ravi");
        head = addFirst(head, "Neha");
        head = addLast(head, "Kiran");
        head = addFirst(head, "Mohan");
        printLine(head);
    }
}
// addFirst: O(1). addLast: O(n) without a tail pointer; O(1) with one.
