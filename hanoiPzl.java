public class HanoiTower {

    private static int moveCount = 0;

    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            moveCount++;
            System.out.println("Move " + moveCount + ": Disk 1 from " + source + " to " + destination);
            return;
        }
        
        solveHanoi(n - 1, source, destination, auxiliary);
        
        moveCount++;
        System.out.println("Move " + moveCount + ": Disk " + n + " from " + source + " to " + destination);
        
        solveHanoi(n - 1, auxiliary, source, destination);
    }
