class UnboundedArrayStack {
    private int[] arr;
    private int top;

    public UnboundedArrayStack() {
        arr = new int[2]; // initial size
        top = -1;
    }

    // Push
    public void push(int x) {
        if (top == arr.length - 1)
            resize(arr.length * 2);

        arr[++top] = x;
    }

    // Pop
    public int pop() {
        if (top == -1)
            throw new RuntimeException("Stack is empty");

        int value = arr[top--];

        if (top >= 0 && top == arr.length / 4)
            resize(arr.length / 2);

        return value;
    }

    private void resize(int newSize) {
        int[] newArr = new int[newSize];
        for (int i = 0; i <= top; i++)
            newArr[i] = arr[i];
        arr = newArr;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
