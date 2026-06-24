class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

public class circular_doubly {

    Node head = null;

    // Insert First
    void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev=head;
        } else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;

            head = newNode;
        }
    }

    // Insert Last
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

        circular_doubly list = new circular_doubly();

        list.insertFirst(20);
        list.insertFirst(10);

        System.out.println("After insertFirst():");
        list.display();

        list.insertLast(30);
        list.insertLast(40);

        System.out.println("After insertLast():");
        list.display();

        System.out.println("After insertAtPosition(25,3):");
        list.display();
    }
}