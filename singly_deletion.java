class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
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
    }

    void delete_first(){
        if(head==null){
            return;
        }
        head=head.next;
    }
    
    //delete at last
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

    while (temp.next.next != null) {
        temp = temp.next;   
    }

    temp.next = null;
}

    // Delete Node at Position (1-based)
    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid Position");
            return;
        }

        temp.next = temp.next.next;
    }

    // Delete Given Value
    void deleteValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

public class singly_deletion {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Original List:");
        list.display();
         
        list.delete_first();
        list.display();

        list.deleteLast();
        System.out.println("After deleteLast():");
        list.display();


        list.deleteValue(30);
        System.out.println("After deleteValue(30):");
        list.display();

        list.deleteAtPosition(2);
        System.out.println("After deleteAtPosition(2):");
        list.display();
    }
} 