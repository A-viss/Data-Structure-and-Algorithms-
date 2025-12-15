import java.util.Stack;

class QueueStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Push: O(1)
    void enqueue(int x) {
        s1.push(x);
    }

    // Pop: O(n)
    int dequeue() {
        if (s1.isEmpty()) throw new RuntimeException("Queue is empty");

        while (!s1.isEmpty())
            s2.push(s1.pop());

        int val = s2.pop();

        while (!s2.isEmpty())
            s1.push(s2.pop());

        return val;
    }
}
