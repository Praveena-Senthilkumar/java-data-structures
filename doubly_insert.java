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

    // Insert at Beginning
    void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }

        head = newNode;
    }

    // Insert at End
    void insertLast(int data) {
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

    // Insert at Position (1-based)
    void insertAtPosition(int pos, int data) {
        if (pos == 1) {
            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // Display Forward
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    void reverseDisplay() {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    Node temp = head;

    // Move to last node
    while (temp.next != null) {
        temp = temp.next;
    }

    // Traverse backwards
    while (temp != null) {
        System.out.print(temp.data + " <-> ");
        temp = temp.prev;
    }

    System.out.println("null");
}
}

public class doubly_insert {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);

        System.out.println("After insertFirst:");
        list.display();

        list.insertLast(30);
        list.insertLast(40);

        System.out.println("\nAfter insertLast:");
        list.display();

        list.insertAtPosition(3, 25);

        System.out.println("Reversed display");
        list.reverseDisplay();

        System.out.println("\nAfter insertAtPosition(3, 25):");
        list.display();


    }
} 