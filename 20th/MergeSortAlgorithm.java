public class MergeSort {
    

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, temp, 0, arr.length - 1);
    }
    
    private static void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Recursively sort left and right halves
            mergeSortHelper(arr, temp, left, mid);
            mergeSortHelper(arr, temp, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, temp, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy data to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left;      // Index for left subarray
        int j = mid + 1;   // Index for right subarray
        int k = left;      // Index for merged array
        
        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        
        // Copy remaining elements from left subarray
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        
        // Copy remaining elements from right subarray (if any)
        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
    

    public static void optimizedMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int[] temp = new int[arr.length];
        optimizedMergeSortHelper(arr, temp, 0, arr.length - 1);
    }
    
    private static final int INSERTION_SORT_THRESHOLD = 10;
    
    private static void optimizedMergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (right - left + 1 <= INSERTION_SORT_THRESHOLD) {
            // Use insertion sort for small subarrays
            insertionSort(arr, left, right);
            return;
        }
        
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            optimizedMergeSortHelper(arr, temp, left, mid);
            optimizedMergeSortHelper(arr, temp, mid + 1, right);
            
            // Skip merge if already sorted
            if (arr[mid] <= arr[mid + 1]) {
                return;
            }
            
            merge(arr, temp, left, mid, right);
        }
    }
    
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void iterativeMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int n = arr.length;
        int[] temp = new int[n];
        
        // Start with subarrays of size 1, then 2, 4, 8, etc.
        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                
                merge(arr, temp, left, mid, right);
            }
        }
    }
    
    public static void inPlaceMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        inPlaceMergeSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void inPlaceMergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            inPlaceMergeSortHelper(arr, left, mid);
            inPlaceMergeSortHelper(arr, mid + 1, right);
            
            inPlaceMerge(arr, left, mid, right);
        }
    }
    
    private static void inPlaceMerge(int[] arr, int left, int mid, int right) {
        int start2 = mid + 1;
        
        // If already sorted, no need to merge
        if (arr[mid] <= arr[start2]) {
            return;
        }
        
        while (left <= mid && start2 <= right) {
            if (arr[left] <= arr[start2]) {
                left++;
            } else {
                int value = arr[start2];
                int index = start2;
                
                // Shift all elements between left and start2 right by 1
                while (index != left) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[left] = value;
                
                left++;
                mid++;
                start2++;
            }
        }
    }
    

    public static void threeWayMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int[] temp = new int[arr.length];
        threeWayMergeSortHelper(arr, temp, 0, arr.length - 1);
    }
    
    private static void threeWayMergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (right - left < 2) {
            if (right > left && arr[left] > arr[right]) {
                swap(arr, left, right);
            }
            return;
        }
        
        int mid1 = left + (right - left) / 3;
        int mid2 = left + 2 * (right - left) / 3;
        
        threeWayMergeSortHelper(arr, temp, left, mid1);
        threeWayMergeSortHelper(arr, temp, mid1 + 1, mid2);
        threeWayMergeSortHelper(arr, temp, mid2 + 1, right);
        
        threeWayMerge(arr, temp, left, mid1, mid2, right);
    }
    
    private static void threeWayMerge(int[] arr, int[] temp, int left, int mid1, int mid2, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left, j = mid1 + 1, k = mid2 + 1, l = left;
        
        while (i <= mid1 && j <= mid2 && k <= right) {
            if (temp[i] <= temp[j] && temp[i] <= temp[k]) {
                arr[l++] = temp[i++];
            } else if (temp[j] <= temp[i] && temp[j] <= temp[k]) {
                arr[l++] = temp[j++];
            } else {
                arr[l++] = temp[k++];
            }
        }
        
        while (i <= mid1 && j <= mid2) {
            arr[l++] = (temp[i] <= temp[j]) ? temp[i++] : temp[j++];
        }
        
        while (i <= mid1 && k <= right) {
            arr[l++] = (temp[i] <= temp[k]) ? temp[i++] : temp[k++];
        }
        
        while (j <= mid2 && k <= right) {
            arr[l++] = (temp[j] <= temp[k]) ? temp[j++] : temp[k++];
        }
        
        while (i <= mid1) arr[l++] = temp[i++];
        while (j <= mid2) arr[l++] = temp[j++];
        while (k <= right) arr[l++] = temp[k++];
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
