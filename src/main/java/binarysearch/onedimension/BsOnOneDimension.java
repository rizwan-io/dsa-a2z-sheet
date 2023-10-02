package binarysearch.onedimension;

public class BsOnOneDimension {

    public static void main(String[] args) {
        boolean i = search3(new int[]{1,0,1,1,1}, 0);
        System.out.println(i);
    }

    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    // Search in Rotated Sorted Array II (Duplicate elements)
    public static boolean search3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            } else {
                // trimming down the search context
                if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                    low++;
                    high--;
                }
                // either left or right part would be sorted
                else if (nums[low] <= nums[mid]) {
                    // left part is sorted
                    if (nums[low] <= target && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] <= nums[high]) {
                    // right part is sorted
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return false;
    }

    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    // Search in Rotated Sorted Array (Unique Elements)
    public static int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                // either left or right part would be sorted
                if (nums[low] <= nums[mid]) {
                    // left part is sorted
                    if (nums[low] <= target && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] <= nums[high]) {
                    // right part is sorted
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

    public static int count(int arr[], int n, int x) {
        int low = 0;
        int high = n - 1;

        int firstOccurrence = -1;
        int lastOccurence = -1;


        // do for left
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                firstOccurrence = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                lastOccurence = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (lastOccurence == -1 || firstOccurrence == -1) return 0;
        return lastOccurence - firstOccurrence + 1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int low = 0;
        int high = nums.length - 1;

        int firstOccurrence = -1;
        int lastOccurence = -1;


        // do for left
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                firstOccurrence = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                lastOccurence = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        result[0] = firstOccurrence;
        result[1] = lastOccurence;

        return result;
    }

    // https://www.codingninjas.com/studio/problems/ceiling-in-a-sorted-array_1825401
    // Ceil the Floor
//    public static int ceilingInSortedArray(int n, int x, int[] arr) {
//
//    }

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
