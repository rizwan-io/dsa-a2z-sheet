package binarysearch.onedimension;

public class BsOnOneDimension {

    public static void main(String[] args) {
        int i = findPeakElement(new int[]{3,4,3,2,1});
        System.out.println(i);
    }


    // https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679
    // Find Nth Root Of M
    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while(low <= high) {
            int mid = (low + high) / 2;
            int ans = (int) Math.pow(mid, n);
            if (ans == m) {
                return mid;
            } else if (ans < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // https://www.codingninjas.com/studio/problems/square-root-integral_893351
    // Square Root of a number
    public static int sqrtN(long N) {
        long low = 1;
        long high = N;

        while(low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid == N) {
                return (int) mid;
            } else if (mid * mid < N) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) high;
    }

    // https://leetcode.com/problems/find-peak-element/
    // Find Peak Element
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // exit the loop when we only have 2 elements
        while (low < high - 1) {
            int mid = (low + high) / 2;
            // mid is the peak element - fails in case where mid = 0 or n-1
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            // check if the series is decreasing or not
            // if the series is decreasing then the peak lies on the left part
            else if (nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]) {
                high = mid -1;
            }
            // else if the series is increasing then the peak lies on the right part
            else {
                low = mid + 1;
            }
        }


        if (low == high) return low;
        if (nums[low] > nums[low+1]) return low;
        else return high;
    }

    // https://leetcode.com/problems/single-element-in-a-sorted-array/
    // Single Element in a Sorted Array
    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) {
                return nums[mid];
            } else {
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid+1]) {
                        low = mid + 2;
                    } else {
                        high = mid -2;
                    }
                } else {
                    if (nums[mid] == nums[mid-1]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return nums[low];
    }

    // https://www.codingninjas.com/studio/problems/rotation_7449070
    // Rotation
    public static int findKRotation(int []nums){
        int low = 0;
        int high = nums.length - 1;
        int minimum = Integer.MAX_VALUE;
        int result = -1;


        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[low] <= nums[mid]) {
                if (minimum > nums[low]) {
                    minimum = nums[low];
                    result = low;
                }
                low = mid + 1;
            } else if(nums[mid] <= nums[high]) {
                if (minimum > nums[mid]) {
                    minimum = nums[mid];
                    result = mid;
                }
                high = mid - 1;
            }
        }

        return result;
    }

    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    // Find Minimum in Rotated Sorted Array
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int minimum = Integer.MAX_VALUE;


        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[low] <= nums[mid]) {
                minimum = Math.min(minimum, nums[low]);
                low = mid + 1;
            } else if(nums[mid] <= nums[high]) {
                minimum = Math.min(minimum, nums[mid]);
                high = mid - 1;
            }
        }

        return minimum;
    }

    // 4,5,6,7,0,1,2

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
