package arrays.medium;

import java.util.*;

public class MediumArrayProblems {

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
