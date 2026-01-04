class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedListQueue {
    private Node front, rear;

    // Enqueue: add to the rear
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue: remove from the front
    public int dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue Underflow");
        }
        int value = front.data;
        front = front.next;
        if (front == null) rear = null; // queue is empty now
        return value;
    }

    // Peek front element
    public int peek() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display queue elements
    public void display() {
        Node curr = front;
        System.out.print("Queue: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
