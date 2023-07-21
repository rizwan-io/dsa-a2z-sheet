package learnthebasics.sorting;

public class BubbleSort {
    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                // swap the elements if the next element is greater than the previous
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // improvised bubble sort using a flag
    // if no swap has been made in a pass that means the array is sorted
    public static void bubbleSortImprovised(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n-i-1; j++) {
                // swap the elements if the next element is greater than the previous
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }
}
