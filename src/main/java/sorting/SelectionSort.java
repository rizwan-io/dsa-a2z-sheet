package sorting;

public class SelectionSort {

    public static void selectionSort2(int arr[], int n) {
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }


    // === Selection sort divided into 2 methods for simplicity === //

    // method to return the index of the minimum element.
    public static int  select(int arr[], int i) {
        int minIndex = i;
        for (; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n-1; i++) {
            int minIndex = select(arr, i);
            // replace the min integer with the ith index
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
