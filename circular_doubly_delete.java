class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

public class circular_doubly_delete{

    Node head = null;

    // Insert Last (for creating list)
    void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;
        }
    }

    // Delete First
    void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;

        head = head.next;
        head.prev = last;
        last.next = head;
    }

    // Delete Last
    void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;
        Node secondLast = last.prev;

        secondLast.next = head;
        head.prev = secondLast;
    }

    // Delete at Position
    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos && temp.next != head; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(head)");
    }

    public static void main(String[] args) {

        circular_doubly_delete list = new circular_doubly_delete();

        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertLast(50);

        System.out.println("Original List:");
        list.display();

        list.deleteFirst();
        System.out.println("After deleteFirst():");
        list.display();

        list.deleteLast();
        System.out.println("After deleteLast():");
        list.display();

        list.deleteAtPosition(2);
        System.out.println("After deleteAtPosition(2):");
        list.display();
    }
}