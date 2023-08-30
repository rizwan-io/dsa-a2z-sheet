package sorting;

public class QuickSort {
    public static void quickSort(int arr[], int low, int high) {
        if (low >= high) return;

        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
    }
    public static int partition(int arr[], int low, int high) {
        int pivot = low;
        while (low <= high) {
            while (low <= high && arr[pivot] >= arr[low]) {
                low++;
            }
            while (low <= high && arr[pivot] <= arr[high]) {
                high--;
            }
            if (low <= high) {
                int temp = arr[low];
                arr[low++] = arr[high];
                arr[high--] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[pivot];
        arr[pivot] = temp;
        return high;
    }
}
