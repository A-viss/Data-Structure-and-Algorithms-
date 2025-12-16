import java.util.LinkedList;
import java.util.Queue;

class QueueStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    // Constructor
    public QueueStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push operation - O(n) time complexity
    public void push(int x) {
        // Add new element to q2
        q2.add(x);
        
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Pop operation - O(1) time complexity
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return q1.remove();
    }
    
    // Peek operation - O(1) time complexity
    public int peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return q1.peek();
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    
    // Get size of stack
    public int size() {
        return q1.size();
    }
    
    // Display stack elements
    public void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Stack elements: " + q1);
    }
}
