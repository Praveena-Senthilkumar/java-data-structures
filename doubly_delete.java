class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Insert at End
    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete First Node
    void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // Delete Last Node
    void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }

    // Delete at Position (1-based)
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

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        if (temp.next == null) { // last node
            temp.prev.next = null;
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Delete by Value
    void deleteValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp == head) {
            deleteFirst();
            return;
        }

        if (temp.next == null) {
            temp.prev.next = null;
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Display
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

public class doubly_delete{
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Original List:");
        list.display();

        list.deleteFirst();
        System.out.println("\nAfter deleteFirst():");
        list.display();

        list.deleteLast();
        System.out.println("\nAfter deleteLast():");
        list.display();

        list.deleteAtPosition(2);
        System.out.println("\nAfter deleteAtPosition(2):");
        list.display();

        list.deleteValue(40);
        System.out.println("\nAfter deleteValue(40):");
        list.display();
    }
}