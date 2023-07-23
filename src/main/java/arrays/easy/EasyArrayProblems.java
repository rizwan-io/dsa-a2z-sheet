package arrays.easy;

import java.util.*;

public class EasyArrayProblems {

    // Longest Subarray With Sum K - Only Positives and Zeroes - Optimal
    public static int longestSubarrayWithSumK(int []a, long k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int n = a.length;
        int max = 0;

        while (right < n) {
            sum += a[right];
            while (sum > k && left <= right) {
                sum -= a[left];
                left++;
            }
            if (sum == k) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }

        return max;
    }

    // Longest Sub-Array with Sum K - Optimal
    public static int lenOfLongSubarr2(int A[], int N, int K) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }
            if (sum == K) {
                max = i+1;
            } else if (hashMap.containsKey(sum-K)) {
                max = Math.max(max, i - hashMap.get(sum-K));
            }
        }
        return max;
    }

    // Longest Sub-Array with Sum K - Bruteforce
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                if (sum == K) {
                    int count = j - i + 1;
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }

    // Single Number - Optimal
    public int singleNumber3(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    // Single Number - Better
    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    // Single Number - Bruteforce
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-1; i+=2) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[n-1];
    }

    // Max Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) count++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    // Missing Number - Optimal
    public static int missingNumber3(int A[], int N) {
        // Functional code to find the sum of an array. We can also use for-loop
        int sum = Arrays.stream(A).sum();

        int expectedSum = (N * (N+1)) / 2;
        return expectedSum - sum;
    }

    // Missing Number - Better
    public static int missingNumber2(int A[], int N) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            hashMap.put(i, 0);
        }
        for (int num : A) {
            hashMap.put(num, 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 0) return entry.getKey();
        }
        return -1;
    }

    // Missing Number - Bruteforce
    public static int missingNumber(int A[], int N) {
        for (int i = 1; i <= N; i++) {
            boolean numFound = false;
            for (int j = 0; j < N; j++) {
                if (A[j] == i) {
                    numFound = true;
                    break;
                }
            }
            if (!numFound) return i;
        }
        return -1;
    }


    // Union of the two sorted arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        // inserting the first element so that we don't have to check for empty list
        // while getting the peak element
        list.add(Math.min(arr1[i], arr2[j]));

        while (i < n && j < m) {
            if (arr1[i] == list.get(list.size()-1)) i++;
            else if (arr2[j] == list.get(list.size()-1)) j++;
            else if (arr1[i] < arr2[j]) list.add(arr1[i++]);
            else if (arr2[j] < arr1[i]) list.add(arr2[j++]);
            else {
                list.add(arr1[i++]);
                j++;
            }
        }

        while (i < n) {
            if (arr1[i] != list.get(list.size()-1)) list.add(arr1[i]);
            i++;
        }

        while (j < m) {
            if (arr2[j] != list.get(list.size()-1)) list.add(arr2[j]);
            j++;
        }

        return list;
    }

    // Searching an element in a sorted array
    static int searchInSorted(int arr[], int N, int K) {
        int result = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == K)
                return 1;
        }
        return -1;
    }

    // Move all zeroes to end of array - Optimal
    void pushZerosToEnd2(int[] arr, int n) {
        int j = 0;
        while (j < n && arr[j] != 0) {
            j++;
        }

        for (int i = j+1; i < n; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                arr[i] = 0;
                j++;
            }
        }
    }

    // Move all zeroes to end of array - Bruteforce
    void pushZerosToEnd(int[] arr, int n) {
        int[] duplicateArr = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                duplicateArr[j++] = arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i < j) {
                arr[i] = duplicateArr[i];
            } else {
                arr[i] = 0;
            }
        }

    }

    // Left Rotate an Array by D Places - Optimal Clean Code
    void leftRotate3(int[] arr, int n, int d) {
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);
    }

    private static void reverseArray(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    // Left Rotate an Array by D Places - Better
    void leftRotate2(int[] arr, int n, int d) {
        int duplicateArr[] = new int[n];
        int j = 0;
        for (int i = d; i < n; i++) {
            duplicateArr[j++] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            duplicateArr[j++] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = duplicateArr[i];
        }
    }

    // Left Rotate an Array by D Places - Bruteforce
    void leftRotate(int[] arr, int n, int d) {
        while (d > 0) {
            int temp = arr[0];
            for (int i = 1; i < n; i++) {
                arr[i - 1] = arr[i];
            }
            arr[n - 1] = temp;
            d--;
        }
    }

    // Left Rotate an Array by One
    public static int[] rotateArray(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        return arr;
    }

    // Remove duplicate elements from sorted Array - Optimal
    public static int remove_duplicate2(int A[],int N){
        int i = 0;
        int j = 1;
        int count = 1;

        while (j < N) {
            if (A[j] != A[i]) {
                A[++i] = A[j];
                count++;
            }
            j++;
        }
        return count;
    }

    // Remove duplicate elements from sorted Array - Bruteforce
    public static int remove_duplicate(int A[],int N){
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        for (int num : A) {
            hashSet.add(num);
        }

        int i = 0;
        for (int num : hashSet) {
            A[i++] = num;
        }
        return hashSet.size();
    }

    // Check if array is sorted
    public static boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            if (arr[i+1] < arr[i]) return false;
        }
        return true;
    }

    // Second largest - optimal
    public static int print2largest2(int arr[], int n) {
        int max = arr[0];
        int secondMax = -1;

        for (int i = 1 ; i < n; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // Second largest - bruteforce
    public static int print2largest(int arr[], int n) {
        Arrays.sort(arr);
        int max = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] != max) return arr[i];
        }
        return -1;
    }


    // Largest Element in Array
    public static int largest(int arr[], int n) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
}
