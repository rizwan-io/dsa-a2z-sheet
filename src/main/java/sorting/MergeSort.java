package sorting;

public class MergeSort {
    void mergeSort(int arr[], int l, int r) {
        if (l == r) return;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);

        int i = l;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[r - l + 1];

        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i];
                i++;
            } else {
                temp[k++] = arr[j];
                j++;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        k = 0;
        while (l <= r) {
            arr[l++] = temp[k++];
        }
    }
}
