public class Problem4_CancelBooking {
    static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

    static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }
        if (head.data.equals(booking)) return head.next;

        Node p = head;
        while (p.next != null && !p.next.data.equals(booking))
            p = p.next;

        if (p.next == null) System.out.println(booking + " not found");
        else p.next = p.next.next;
        return head;
    }

    static Node build(String[] ids) {
        Node head = null, tail = null;
        for (String id : ids) {
            Node p = new Node(id);
            if (head == null) head = p;
            else tail.next = p;
            tail = p;
        }
        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = build(new String[]{"104", "101", "107", "101"});
        head = removeFirst(head, "101");
        print(head);
        head = removeFirst(head, "200");
        print(head);
    }
}
// Head match: O(1). End or absent: O(n) in the worst case.
