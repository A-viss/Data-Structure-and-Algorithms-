public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
        
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // Add at beginning
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    // Add at end
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    // Remove first element
    public T removeFirst() {
        if (head == null) return null;
        
        T data = head.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }
    
    // Remove last element
    public T removeLast() {
        if (tail == null) return null;
        
        T data = tail.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }
    
    // Remove specific element
    public boolean remove(T data) {
        Node<T> current = head;
        
        while (current != null) {
            if (current.data.equals(data)) {
                // If node is head
                if (current == head) {
                    removeFirst();
                }
                // If node is tail
                else if (current == tail) {
                    removeLast();
                }
                // Node is in middle
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Get element at index
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        
        Node<T> current;
        
        // Start from head or tail depending on index
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }
    
    // Check if contains element
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
