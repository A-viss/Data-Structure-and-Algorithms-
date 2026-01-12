public class BubbleSort {
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    

    public static void bubbleSortOptimized(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swaps occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
    

    public static void bubbleSortWithVisualization(int[] arr) {
        int n = arr.length;
        int passCount = 0;
        
        System.out.println("Initial array: " + arrayToString(arr));
        System.out.println();
        
        for (int i = 0; i < n - 1; i++) {
            passCount++;
            boolean swapped = false;
            System.out.println("Pass " + passCount + ":");
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    System.out.println("  Swapped " + arr[j + 1] + " and " + arr[j] + 
                                     " -> " + arrayToString(arr));
                }
            }
            
            if (!swapped) {
                System.out.println("  No swaps - array is sorted!");
                break;
            }
            System.out.println();
        }
        
        System.out.println("Final sorted array: " + arrayToString(arr));
    }
    

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    

    public static void printArray(int[] arr) {
        System.out.println(arrayToString(arr));
    }
