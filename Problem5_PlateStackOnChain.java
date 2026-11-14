public class Problem5_PlateStackOnChain {
    static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

    static class Stack {
        Node top;
        int size;

        boolean isEmpty() { return top == null; }

        void push(String plate) {
            Node p = new Node(plate);
            p.next = top;
            top = p;
            size++;
            System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
        }

        String pop() {
            if (isEmpty()) {
                System.out.println("pop -> stack is empty");
                return null;
            }
            String plate = top.data;
            top = top.next;
            size--;
            System.out.println("pop -> " + plate + ", size " + size);
            return plate;
        }

        String peek() {
            if (isEmpty()) {
                System.out.println("peek -> stack is empty");
                return null;
            }
            System.out.println("peek -> " + top.data);
            return top.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("P1");
        s.push("P2");
        s.peek();
        s.pop();
        s.push("P3");
        s.pop();
        s.pop();
        s.pop();
        System.out.println("isEmpty -> " + s.isEmpty());
    }
}
// Linked stack: push, pop, peek, isEmpty are O(1); grows dynamically.
// Array stack: same O(1) operations, but fixed capacity unless resized.
