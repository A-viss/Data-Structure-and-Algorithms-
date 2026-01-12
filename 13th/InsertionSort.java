public class InsertionSort {
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert key at correct position
            arr[j + 1] = key;
        }
    }
    

    public static void insertionSortWithVisualization(int[] arr) {
        int n = arr.length;
        
        System.out.println("Initial array: " + arrayToString(arr));
        System.out.println();
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            System.out.println("Step " + i + ": Inserting " + key);
            System.out.println("  Before: " + arrayToString(arr));
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
            System.out.println("  After:  " + arrayToString(arr));
            System.out.println();
        }
        
        System.out.println("Final sorted array: " + arrayToString(arr));
    }
    
    public static void binaryInsertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            
            // Find position using binary search
            int pos = binarySearch(arr, key, 0, i - 1);
            
            // Shift elements to make space
            for (int j = i - 1; j >= pos; j--) {
                arr[j + 1] = arr[j];
            }
            
            // Insert key at found position
            arr[pos] = key;
        }
    }
    

    private static int binarySearch(int[] arr, int key, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == key) {
                return mid + 1;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    /**
     * Insertion Sort for descending order
     */
    public static void insertionSortDescending(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements smaller than key one position ahead
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    

    public static void insertionSortWithSentinel(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;
        
        // Find minimum and place at index 0
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }
        swap(arr, 0, minIdx);
        
        // Now perform insertion sort without boundary check
        for (int i = 2; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // No need to check j >= 0 because arr[0] is sentinel
            while (arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    
    public static void insertionSortRecursive(int[] arr, int n) {
        // Base case
        if (n <= 1) return;
        
        // Sort first n-1 elements
        insertionSortRecursive(arr, n - 1);
        
        // Insert last element at correct position
        int key = arr[n - 1];
        int j = n - 2;
        
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        
        arr[j + 1] = key;
    }
    
    /**
     * Helper method to swap elements
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Helper method to convert array to string
     */
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Helper method to print array
     */
    public static void printArray(int[] arr) {
        System.out.println(arrayToString(arr));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Standard insertion sort
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("=== Standard Insertion Sort ===");
        System.out.print("Before: ");
        printArray(arr1);
        insertionSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        
        // Test Case 2: Visualization
        int[] arr2 = {5, 2, 4, 6, 1, 3};
        System.out.println("\n=== Insertion Sort with Visualization ===");
        insertionSortWithVisualization(arr2);
        
        // Test Case 3: Binary insertion sort
        int[] arr3 = {37, 23, 0, 17, 12, 72, 31};
        System.out.println("\n=== Binary Insertion Sort ===");
        System.out.print("Before: ");
        printArray(arr3);
        binaryInsertionSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        
        // Test Case 4: Descending order
        int[] arr4 = {5, 2, 8, 1, 9};
        System.out.println("\n=== Insertion Sort (Descending) ===");
        System.out.print("Before: ");
        printArray(arr4);
        insertionSortDescending(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        
        // Test Case 5: Recursive insertion sort
        int[] arr5 = {12, 11, 13, 5, 6};
        System.out.println("\n=== Recursive Insertion Sort ===");
        System.out.print("Before: ");
        printArray(arr5);
        insertionSortRecursive(arr5, arr5.length);
        System.out.print("After:  ");
        printArray(arr5);
        
        // Test Case 6: Nearly sorted (best case)
        int[] arr6 = {1, 2, 3, 5, 4, 6, 7};
        System.out.println("\n=== Nearly Sorted Array (Best Case) ===");
        System.out.print("Before: ");
        printArray(arr6);
        insertionSort(arr6);
        System.out.print("After:  ");
        printArray(arr6);
    }
}
