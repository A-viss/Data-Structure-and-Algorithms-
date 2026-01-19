public class OptimizedQuickSort {
    
    private static final int INSERTION_THRESHOLD = 10;
    
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHelper(int[] arr, int low, int high) {
        while (high - low > INSERTION_THRESHOLD) {
            int pi = partition(arr, low, high);
            
            // Tail recursion: recurse on smaller half, loop on larger
            if (pi - low < high - pi) {
                quickSortHelper(arr, low, pi - 1);
                low = pi + 1;
            } else {
                quickSortHelper(arr, pi + 1, high);
                high = pi - 1;
            }
        }
        
        // Use insertion sort for small subarrays
        if (high > low) {
            insertionSort(arr, low, high);
        }
    }
    

    private static int partition(int[] arr, int low, int high) {
        // Median-of-three
        int mid = low + (high - low) / 2;
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
