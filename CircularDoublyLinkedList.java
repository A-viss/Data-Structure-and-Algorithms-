class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class CircularDoublyLinkedList {
    private Node head;

    // Insert at the front
    public void insertFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head;
        } else {
            Node tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head;
        } else {
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Insert at a specific position (1-based)
    public void insertAtPosition(int data, int pos) {
        if (pos <= 1) {
            insertFront(data);
            return;
        }
        Node newNode = new Node(data);
        Node curr = head;
        int count = 1;
        while (count < pos - 1 && curr.next != head) {
            curr = curr.next;
            count++;
        }
        Node nextNode = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    // Delete from front
    public void deleteFront() {
        if (head == null) return;
        if (head.next == head) { // only one node
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    // Delete from end
    public void deleteEnd() {
        if (head == null) return;
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            Node newTail = tail.prev;
            newTail.next = head;
            head.prev = newTail;
        }
    }

    // Delete at specific position (1-based)
    public void deleteAtPosition(int pos) {
        if (head == null) return;
        if (pos == 1) {
            deleteFront();
            return;
        }
        Node curr = head;
        int count = 1;
        while (count < pos && curr.next != head) {
            curr = curr.next;
            count++;
        }
        if (curr == head) return; // position out of bounds
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }
