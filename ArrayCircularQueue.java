
public class ArrayCircularQueue<T> {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    // Add element to rear
    public boolean enqueue(T data) {
        if (isFull()) {
            return false;
        }
        
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        return true;
    }
    
    // Remove element from front
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        T data = (T) queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return data;
    }
    
    // Get front element without removing
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) queue[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public int size() {
        return size;
    }
    
    public int capacity() {
        return capacity;
    }
