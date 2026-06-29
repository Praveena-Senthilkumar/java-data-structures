class StackArray {
    int[] stack;
    int top;
    int size;

    StackArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // Push Operation
    void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = data;
        System.out.println(data + " pushed into stack");
    }

    // Pop Operation
    void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(stack[top--] + " popped from stack");
    }

    // Peek Operation
    void peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top element: " + stack[top]);
    }


    public static void main(String[] args) {

        StackArray s = new StackArray(5);

        s.push(10);
        s.push(20);
        s.push(30);

        s.peek();

        s.pop();

    }
}