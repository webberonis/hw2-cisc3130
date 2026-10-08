
public class Homework2 {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted sections
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Display Array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Test Linear Search
    public static void testLinearSearch(int[] arr, int target) {
        System.out.println("Searching for " + target);

        int index = linearSearch(arr, target);

        if (index == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target found at index " + index);
        }
    }

    // Test Binary Search
    public static void testBinarySearch(int[] arr, int target) {
        System.out.println("Searching for " + target);

        int index = binarySearch(arr, target);

        if (index == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target found at index " + index);
        }
    }

    // Main Program
    public static void main(String[] args) {

        // Create Original Array
        int[] original = {42, 15, 78, 6, 93, 27, 51, 10, 84, 33, 69, 21};

        // Create Copies for Sorting
        int[] bubble = original.clone();
        int[] merge = original.clone();

        // Display Original Array
        System.out.println("Original Array:");
        printArray(original);

        // Bubble Sort Result
        bubbleSort(bubble);
        System.out.println("\nBubble Sort Result:");
        printArray(bubble);

        // Merge Sort Result
        mergeSort(merge, 0, merge.length - 1);
        System.out.println("\nMerge Sort Result:");
        printArray(merge);

        // Linear Search Test Cases
        System.out.println("\nLinear Search");
        testLinearSearch(original, 15);
        testLinearSearch(original, 69);
        testLinearSearch(original, 500);

        // Binary Search Test Cases
        System.out.println("\nBinary Search");
        testBinarySearch(bubble, 10);
        testBinarySearch(bubble, 93);
        testBinarySearch(bubble, 500);
    }
}
