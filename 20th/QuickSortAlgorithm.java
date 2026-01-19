public class QuickSort {
    
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
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
    
    public static void quickSortMedian(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSortMedianHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortMedianHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionMedian(arr, low, high);
            
            quickSortMedianHelper(arr, low, pi - 1);
            quickSortMedianHelper(arr, pi + 1, high);
        }
    }
    
    private static int partitionMedian(int[] arr, int low, int high) {
        // Choose median of first, middle, and last as pivot
        int mid = low + (high - low) / 2;
        
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        
        // Place pivot at high position
        swap(arr, mid, high);
        
        return partition(arr, low, high);
    }
    
    public static void optimizedQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        optimizedQuickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static final int INSERTION_THRESHOLD = 10;
    
    private static void optimizedQuickSortHelper(int[] arr, int low, int high) {
        if (high - low + 1 <= INSERTION_THRESHOLD) {
            insertionSort(arr, low, high);
            return;
        }
        
        if (low < high) {
            int pi = partitionMedian(arr, low, high);
            
            optimizedQuickSortHelper(arr, low, pi - 1);
            optimizedQuickSortHelper(arr, pi + 1, high);
        }
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

    public static void threeWayQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        threeWayQuickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void threeWayQuickSortHelper(int[] arr, int low, int high) {
        if (low >= high) return;
        
        int pivot = arr[low];
        int lt = low;      // arr[low..lt-1] < pivot
        int gt = high;     // arr[gt+1..high] > pivot
        int i = low + 1;   // arr[lt..i-1] == pivot
        
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        
        threeWayQuickSortHelper(arr, low, lt - 1);
        threeWayQuickSortHelper(arr, gt + 1, high);
    }
    
    public static void randomizedQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        randomizedQuickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void randomizedQuickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = randomizedPartition(arr, low, high);
            
            randomizedQuickSortHelper(arr, low, pi - 1);
            randomizedQuickSortHelper(arr, pi + 1, high);
        }
    }
    
    private static int randomizedPartition(int[] arr, int low, int high) {
        // Select random pivot and swap with last element
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        swap(arr, randomIndex, high);
        
        return partition(arr, low, high);
    }
    
    public static void iterativeQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int[] stack = new int[arr.length];
        int top = -1;
        
        stack[++top] = 0;
        stack[++top] = arr.length - 1;
        
        while (top >= 0) {
            int high = stack[top--];
            int low = stack[top--];
            
            int pi = partition(arr, low, high);
            
            if (pi - 1 > low) {
                stack[++top] = low;
                stack[++top] = pi - 1;
            }
            
            if (pi + 1 < high) {
                stack[++top] = pi + 1;
                stack[++top] = high;
            }
        }
    }
    
    public static void tailCallQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        tailCallQuickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void tailCallQuickSortHelper(int[] arr, int low, int high) {
        while (low < high) {
            int pi = partition(arr, low, high);
            
            // Recurse on smaller partition, iterate on larger
            if (pi - low < high - pi) {
                tailCallQuickSortHelper(arr, low, pi - 1);
                low = pi + 1;
            } else {
                tailCallQuickSortHelper(arr, pi + 1, high);
                high = pi - 1;
            }
        }
    }
    
    public static void quickSortHoare(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSortHoareHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHoareHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = hoarePartition(arr, low, high);
            
            quickSortHoareHelper(arr, low, pi);
            quickSortHoareHelper(arr, pi + 1, high);
        }
    }
    
    private static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            
            do {
                j--;
            } while (arr[j] > pivot);
            
            if (i >= j) return j;
            
            swap(arr, i, j);
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
