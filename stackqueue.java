import java.util.Stack;

class StackQueueEnqueueFriendly {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue (O(1))
    public void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue (O(n))
    public int dequeue() {
        if (s1.isEmpty())
            throw new RuntimeException("Queue is empty");

        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        int removed = s1.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return removed;
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
