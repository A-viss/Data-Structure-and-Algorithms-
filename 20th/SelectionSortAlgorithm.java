public class SelectionSort {
    
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {

            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }
    
    public static void optimizedSelectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int minIdx = left;
            int maxIdx = right;
            
            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[minIdx]) {
                    minIdx = i;
                }
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }
          
            if (maxIdx == left && minIdx == right) {
                swap(arr, left, right);
            } else {

                if (minIdx != left) {
                    swap(arr, left, minIdx);
                }
                
                if (maxIdx == left) {
                    maxIdx = minIdx;
                }

                if (maxIdx != right) {
                    swap(arr, right, maxIdx);
                }
            }
            
            left++;
            right--;
        }
    }

    public static void stableSelectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            int key = arr[minIdx];
            while (minIdx > i) {
                arr[minIdx] = arr[minIdx - 1];
                minIdx--;
            }
            arr[i] = key;
        }
    }
    
    public static int selectionSortWithCount(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        
        int comparisons = 0;
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
        
        return comparisons;
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
    
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
