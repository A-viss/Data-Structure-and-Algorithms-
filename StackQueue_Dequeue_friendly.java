import java.util.Stack;

public class StackQueue<T> {
    private Stack<T> input;
    private Stack<T> output;
    
    public StackQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    // Add element
    public void enqueue(T item) {
      
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        input.push(item);

        while (!output.isEmpty()) {
            input.push(output.pop());
        }
    }
    
    // Remove front element
    public T dequeue() {
        return input.pop();
    }
    
    public boolean isEmpty() {
        return input.isEmpty();
    }
    
    public int size() {
        return input.size();
    }
    
