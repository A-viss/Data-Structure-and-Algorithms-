public class OptimizedBubbleSort {
    
    public static void standardBubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void optimizedBubbleSort1(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            
            // If no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }
    

    public static void optimizedBubbleSort2(int[] arr) {
        int n = arr.length;
        int newN;
        
        while (n > 1) {
            newN = 0;
            
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    newN = i + 1; // Remember position of last swap
                }
            }
            
            n = newN; // Only need to check up to last swap position
        }
    }

    public static void cocktailShakerSort(int[] arr) {
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;
        
        while (swapped) {
            swapped = false;
            
            // Forward pass: move largest to end
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            
            if (!swapped) break;
            
            end--;
            swapped = false;
            
            // Backward pass: move smallest to start
            for (int i = end; i > start; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }
            
            start++;
        }
    }
    

    public static void adaptiveCocktailSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int lastSwap;
        
        while (left < right) {
            lastSwap = left;
            
            // Forward pass
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    lastSwap = i;
                }
            }
            right = lastSwap;
            
            if (left >= right) break;
            
            lastSwap = right;
            
            // Backward pass
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    lastSwap = i;
                }
            }
            left = lastSwap;
        }
    }
    
    /**
     * Helper method to swap two elements
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Performance testing method
     */
    public static long measureSortTime(int[] arr, String sortType) {
        int[] copy = arr.clone();
        long startTime = System.nanoTime();
        
        switch (sortType) {
            case "standard":
                standardBubbleSort(copy);
                break;
            case "opt1":
                optimizedBubbleSort1(copy);
                break;
            case "opt2":
                optimizedBubbleSort2(copy);
                break;
            case "cocktail":
                cocktailShakerSort(copy);
                break;
            case "adaptive":
                adaptiveCocktailSort(copy);
                break;
        }
        
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
 
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
