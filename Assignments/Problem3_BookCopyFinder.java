public class Problem3_BookCopyFinder {
    static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

    static String find(Node head, String id) {
        int position = 1, first = -1, copies = 0;
        for (Node p = head; p != null; p = p.next, position++) {
            if (p.data.equals(id)) {
                if (first == -1) first = position;
                copies++;
            }
        }
        return first == -1 ? id + " not found" :
               id + " first at position " + first + ", copies: " + copies;
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

    public static void main(String[] args) {
        Node head = build(new String[]{"B12", "B07", "B30", "B07", "B45", "B07"});
        System.out.println(find(head, "B07"));
        System.out.println(find(head, "B99"));
    }
}
// One traversal: O(n) time and O(1) extra space. Linked lists have no direct indexing.
