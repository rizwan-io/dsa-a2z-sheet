package arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HardArrayProblems {

    public static void main(String[] args) {
        List<Integer> list = majorityElement2(new int[]{1, 1, 1});
        System.out.println(list);
    }

    // Majority Element II - Optimal
    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int numBy3 = nums.length/3;
        int element1 = -1;
        int element2 = 0;

        int count1 = 0;
        int count2 = 0;



        for (int k = 0; k < nums.length-1; k++) {
            if (element1 == nums[k]) {
                count1++;
            } else if (element2 == nums[k]) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                element1 = nums[k];
            } else if (count2 == 0) {
                count2++;
                element2 = nums[k];
            } else {
                count2--;
                count1--;
            }
        }

        count1 = 0;
        count2 = 0;
        // now check if element1 and element2 exists more than n/3
        for (int num : nums) {
            if (num == element1) count1++;
            if (num == element2) count2++;
        }

        if (count1 > numBy3) list.add(element1);
        if (count2 > numBy3) list.add(element2);

        return list;
    }

    // Majority Element II - Bruteforce
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length/3;

        for (int num : nums) {
            hashMap.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > n) list.add(entry.getKey());
        }

        return list;
    }
}
