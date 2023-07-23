package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class MediumArrayProblems {

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
