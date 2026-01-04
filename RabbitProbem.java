public class RabbitProblem {
    // Recursive Fibonacci (simple but slower)
    public static int rabbitsRecursive(int n) {
        if (n == 1 || n == 2) return 1;
        return rabbitsRecursive(n - 1) + rabbitsRecursive(n - 2);
    }
}
