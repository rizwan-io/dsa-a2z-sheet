package arrays.medium;

import java.util.*;

public class MediumArrayProblems {

    // Subarray Sum Equals K - Optimal
    public int subarraySum(int[] A, int K) {
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == K) {
                ans++;
            }
            if (hashMap.containsKey(sum-K)) {
                    ans += hashMap.get(sum-K);
            }
            hashMap.merge(sum, 1, Integer::sum);
        }

        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integerList = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;


        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                integerList.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                integerList.add(matrix[i][right]);
            }
            right--;

            // because top has changed so we need to put an extra check
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    integerList.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // because right has changed so we need to put an extra check
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    integerList.add(matrix[i][left]);
                }
                left++;
            }
        }

        return integerList;
    }


    // Rotate Image (Matrix) - Optimal
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }


    // Set Matrix Zeroes - Optimal - Using No extra space
    public static void setZeroes3(int[][] matrix) {
        int extraColumn = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        extraColumn = 0;
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        // Using extraColumn at the last because it can interfere with our matrix
        if (extraColumn == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Set Matrix Zeroes - Better - Using Extra Space - Only for Rows & Columns
    public void setZeroes2(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == 1 || columns[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Set Matrix Zeroes - Bruteforce - Using Extra Space - Entire matrix
    public void setZeroes(int[][] matrix) {
        int ans[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < ans.length; k++) {
                        ans[k][j] = 0;
                    }
                    for (int k = 0; k < ans[0].length; k++) {
                        ans[i][k] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }

    // Longest Consecutive Sequence - Optimal
    public int longestConsecutive2(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : arr) {
            hashSet.add(num);
        }
        int count = 0;
        int max = 0;
        for (int num : hashSet) {
            if (!hashSet.contains(num-1)) {
                int numberToFind = num;
                count = 0;
                while (hashSet.contains(numberToFind)) {
                    count++;
                    numberToFind++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    // Longest Consecutive Sequence - Bruteforce
    public int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr);
        int count = 1;
        int max = 1;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]+1 == arr[i+1]) {
                count++;
            } else if (arr[i] != arr[i+1]) {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    // Leaders in an array - Optimal
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> arrayList = new ArrayList<>();

        int max = arr[n-1];
        arrayList.add(max);

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                arrayList.add(max);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;

    }

    // Next Permutation - Optimal
    public static void nextPermutation(int[] nums) {
        int breakPoint = -1;
        boolean flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                breakPoint = i;
                flag = true;
                break;
            }
        }

        // find minimum which is greater than nums[breakpoint]
        // and replace it with nums[breakpoint] and then sort the array

        if (flag) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[breakPoint]) {
                    int temp = nums[breakPoint];
                    nums[breakPoint] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        Arrays.sort(nums, breakPoint+1, nums.length);
    }

    // Alternate positive and negative numbers - Bruteforce
    void rearrange(int arr[], int n) {
        ArrayList<Integer> positiveList = new ArrayList<>();
        ArrayList<Integer> negativeList = new ArrayList<>();
        for (int num : arr) {
            if (num > 0) positiveList.add(num);
            else negativeList.add(num);
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (j < positiveList.size() && k < negativeList.size()) {
            arr[i++] = positiveList.get(j++);
            arr[i++] = negativeList.get(k++);
        }

        while (j < positiveList.size()) arr[i++] = positiveList.get(j++);
        while (k < negativeList.size()) arr[i++] = negativeList.get(k++);
    }

    // Rearrange Array Elements by Sign - Optimal
    public int[] rearrangeArray2(int[] arr) {
        int ans[] = new int[arr.length];
        int i = 0;
        int j = 1;
        for (int num : arr) {
            if (num > 0) {
                ans[i] = num;
                i+=2;
            }
            else {
                ans[j] = num;
                j+=2;
            }
        }

        return ans;
    }

    // Rearrange Array Elements by Sign - Bruteforce
    public int[] rearrangeArray(int[] arr) {
        ArrayList<Integer> positiveList = new ArrayList<>();
        ArrayList<Integer> negativeList = new ArrayList<>();
        for (int num : arr) {
            if (num > 0) positiveList.add(num);
            else negativeList.add(num);
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr.length) {
            arr[i++] = positiveList.get(j++);
            arr[i++] = negativeList.get(k++);
        }
        return arr;
    }

    // Best Time to Buy and Sell Stock - Optimal
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, (prices[i] - min));
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

    // Maximum Subarray -
    public static int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) sum = 0;
            sum += nums[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    // Maximum Subarray - Bruteforce - Gets TLE
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    // Majority Elements - Optimal
    public int majorityElement2(int[] nums) {
        int element = 0;
        int count = 0;
        for (int num : nums) {
            if (element == num) count++;
            else {
                count--;
                if (count < 0) {
                    count = 0;
                    element = num;
                }
            }
        }
        return element;
    }

    // Majority Elements - Better
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> set : hashMap.entrySet()) {
            if (set.getValue() > (nums.length)/2) {
                return set.getKey();
            }
        }
        return -1;
    }

    // 3. Sort 0s, 1s and 2s - Optimal
    public static void sortColors2(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high) {
            if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                nums[mid] = nums[high];
                nums[high] = 2;
                mid++;
                high--;
            }
        }
    }

    // 3. Sort 0s, 1s and 2s - Better
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 3; i++) hashMap.put(i, 0);

        for (int num : nums) {
            hashMap.merge(num, 1, Integer::sum);
        }
        int index = 0;
        for (int i = 0; i < hashMap.get(0); i++) nums[index++] = 0;
        for (int i = 0; i < hashMap.get(1); i++) nums[index++] = 1;
        for (int i = 0; i < hashMap.get(2); i++) nums[index++] = 3;
    }

    // 2. Two Sum - Variety 2 - Optimal
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                return true;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    // 1. Two Sum - Optimal
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])) {
                return new int[]{i, hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    // 1. Two Sum - Bruteforce
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == target-sum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
