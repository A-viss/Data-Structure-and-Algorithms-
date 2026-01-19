public class OptimizedInsertionSort {
    
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            
            int pos = binarySearch(arr, key, 0, i - 1);
            
            System.arraycopy(arr, pos, arr, pos + 1, i - pos);
            
            arr[pos] = key;
        }
    }
    
    public static void standardInsertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == key) {
                return mid + 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    public static void sentinelInsertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) minIdx = i;
        }
        
        int temp = arr[0];
        arr[0] = arr[minIdx];
        arr[minIdx] = temp;
        
        for (int i = 2; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
