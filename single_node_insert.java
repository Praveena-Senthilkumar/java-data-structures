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

    void insertAtLast(int data) {
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
      

    void insert_at_beginning(int data){
        Node newNode=new Node(data);

        if (head == null) {
            head = newNode;
        }

        else{
        newNode.next=head;
        head=newNode;
        }
    }

    void insert_at_position(int pos,int data){

        Node newNode = new Node(data);

        if (head==null) {
            insertAtLast(data);
        }
        
        else{
        
        Node temp = head;
        for (int i = 1; i <pos; i++) {
        temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        
    }
    
    }
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insert_at_beginning(30);
        list.insert_at_position(2, 50);

        list.display();
    }
}