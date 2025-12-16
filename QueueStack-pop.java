import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public QueueStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element onto stack - O(n) operation
    public void push(int x) {
        // Add new element to empty q2
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
    
    // Pop element from stack - O(1) operation (pop-friendly!)
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }
    
    // Peek at top element - O(1) operation
    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
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
}
