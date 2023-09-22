package binarysearch.onedimension;

public class BsOnOneDimension {

    public static void main(String[] args) {
        int search = search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(search);
    }

    // https://leetcode.com/problems/search-insert-position/description/
    // Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }


    // https://www.codingninjas.com/studio/problems/implement-upper-bound_8165383
    // Upper Bound
    public static int upperBound(int []arr, int x, int n){
        int low = 0;
        int high = n-1;
        int temp = n;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] <= x) {
                low = mid+1;
            } else {
                temp = mid;
                high = mid-1;
            }
        }

        return temp;
    }

    // https://www.codingninjas.com/studio/problems/lower-bound_8165382
    // Lower Bound
    public static int lowerBound(int []arr, int n, int x) {
        int low = 0;
        int high = n-1;
        int temp = n;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] >= x) {
                temp = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return temp;
    }

    // https://leetcode.com/problems/binary-search/
    // Binary Search
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
