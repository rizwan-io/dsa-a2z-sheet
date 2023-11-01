package binarysearch.onedimension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BsOnOneDimension {

    public static void main(String[] args) {
        double x = MinimiseMaxDistance(new int[]{4, 6, 10}, 4);
        System.out.println(x);
    }

    // https://www.codingninjas.com/studio/problems/minimise-max-distance_7541449
    // Minimize Max Distance to Gas Station - Brute force approach
    public static double MinimiseMaxDistance(int []arr, int K){
        double[] distance = new double[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            distance[i] = (arr[i+1] - arr[i]);
        }
        int cycle = 0;
        while (K > 0 ) {
            Arrays.sort(distance);
            for (int i = arr.length - 2; i >= 0; i--) {
                distance[i] = distance[i] / (2.0 + cycle);
                K--;
                if (K == 0) {
                    return Arrays.stream(distance).max().getAsDouble();
                }
            }
            cycle++;
        }

        return -1;
    }


    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int parts = divideBoards(boards, mid);
            if (parts > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static int divideBoards(ArrayList<Integer> boards, int threshold) {
        int sum  = 0;
        int painter = 1;

        for (int i = 0; i < boards.size(); i++) {
            if (sum + boards.get(i) <= threshold) sum += boards.get(i);
            else {
                painter++;
                sum = boards.get(i);
            }
        }

        return painter;
    }

    // https://leetcode.com/problems/split-array-largest-sum/
    // Split Array Largest Sum
    public static int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int parts = divideArray(nums, mid);
            if (parts > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int divideArray(int[] arr, int thresholdSum) {
        int parts = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= thresholdSum) sum += arr[i];
            else {
                parts++;
                sum = arr[i];
            }
        }

        return parts;
    }


    // https://www.codingninjas.com/studio/problems/allocate-books_1090540
    // Allocate Books
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        if (m > n) return -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = studentsAllocated(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static int studentsAllocated(ArrayList<Integer> arr, int thresholdPages) {
        int student = 1;
        int totalPages = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (totalPages + arr.get(i) <= thresholdPages) totalPages += arr.get(i);
            else {
                student++;
                totalPages = arr.get(i);
            }
        }

        return student;
    }

    public static boolean canPlaceCows(int[] stalls, int numberOfCows, int distance) {
        int prevStallIndex = 0;
        int currentStallIndex = 1;
        numberOfCows--;

        while ((numberOfCows != 0) && (currentStallIndex < stalls.length)) {
            if (stalls[currentStallIndex] - stalls[prevStallIndex] >= distance) {
                numberOfCows--;
                prevStallIndex = currentStallIndex;
            }
            currentStallIndex++;
        }

        if (numberOfCows > 0) return false;
        else return true;
    }

    // https://www.codingninjas.com/studio/problems/aggressive-cows_1082559
    // Aggressive Cows
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceCows(stalls, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    // https://leetcode.com/problems/kth-missing-positive-number/
    // Kth Missing Positive Number - O(LogN) Approach
    // arr = [2,3,4,7,11], k = 5
    public static int findKthPositive2(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missingNumber = arr[mid] - mid - 1;
            if (missingNumber >= k) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }

        if (high == -1) return k;
        else {
            int offset = arr[high] - high - 1;
            return arr[high] + k - offset;
        }

    }

    // https://leetcode.com/problems/kth-missing-positive-number/
    // Kth Missing Positive Number - O(N) Approach
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int num = 0;
        int miss = 0;

        while (i < arr.length) {
            num++;
            if (arr[i] == num) i++;
            else miss++;

            if (miss == k) return num;
        }

        return arr[arr.length-1] + (k-miss);
    }

    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    // Capacity To Ship Packages Within D Days
    public static int shipWithinDays(int[] weights, int days) {
        int lowestWeight = Arrays.stream(weights).max().getAsInt();
        int highesWeight = Arrays.stream(weights).sum();
        int result = lowestWeight;

        while (lowestWeight <= highesWeight) {
            int midWeight = (lowestWeight + highesWeight) / 2;

            int sumWeight = 0;
            int daysPassed = 0;

            for (int i = 0; i < weights.length; i++) {
                sumWeight += weights[i];

                if (sumWeight == 0) {
                    daysPassed++;
                    sumWeight = 0;
                } else if (sumWeight > midWeight) {
                    daysPassed++;
                    sumWeight = weights[i];
                }
            }

            if (sumWeight > 0) daysPassed++;

            if (daysPassed <= days) {
                highesWeight = midWeight - 1;
                result = midWeight;
            } else {
                lowestWeight = midWeight + 1;
            }
        }

        return result;
    }

    // https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
    // Find the Smallest Divisor Given a Threshold
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            high = Math.max(nums[i], high);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                int temp = (int) Math.ceil(nums[i] / (double) mid );
                sum += temp;
            }

            if (sum <= threshold) {
                result = mid;
                high = mid - 1;
            } else if (sum > threshold) {
                low = mid + 1;
            }
        }

        return result;
    }

    // https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
    // Minimum Number of Days to Make m Bouquets
    public static int minDays(int[] bloomDay, int m, int k) {
        int low = bloomDay[0];
        int high = bloomDay[0];
        int result = -1;

        // get lows and highs
        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            int flowers = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                int temp = bloomDay[i] - mid;

                if (temp <= 0) count++;
                else count = 0;

                if (count == k) {
                    count = 0;
                    flowers++;
                }
            }

            if (flowers >= m) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // https://leetcode.com/problems/koko-eating-bananas/
    // Koko Eating Bananas
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = 0;

        for (int i = 0 ; i < piles.length; i++) {
            low += piles[i];
            high = Math.max(high, piles[i]);
        }
        low = (low / h);

        while (low <= high) {
            int totalTime = 0;
            int mid = (low + high) / 2;

            for (int i = 0; i < piles.length; i++) {
                totalTime += Math.ceil(piles[i] / (double) mid);
            }

            if (totalTime <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
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
