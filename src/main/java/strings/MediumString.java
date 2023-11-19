package strings;

import java.util.HashMap;
import java.util.Map;

public class MediumString {
    public static void main(String[] args) {
        int beauty = beautySum("aabcb");
        System.out.println(beauty);
    }

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        s = s.strip();

        String[] splitStrings = s.split("[ ]+");

        for (int i = splitStrings.length - 1; i >= 0; i--) {
            stringBuilder.append(splitStrings[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    // Not the best solution
    public static int beautySum(String s) {
        int beauty = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> hashMap = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                hashMap.merge(s.charAt(j), 1, Integer::sum);

                int min = hashMap.get(s.charAt(j));
                int max = min;

                for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                    int value = entry.getValue();
                    min = Math.min(value, min);
                    max = Math.max(value, max);
                }

                beauty += (max - min);
            }
        }

        return beauty;
    }

    public static int countSubStrings(String str, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            hashMap.merge(ch, 1, Integer::sum);

            while (((i - start + 1) > k) && (hashMap.size() > k)) {
                char key = str.charAt(start);
                int freq = hashMap.get(key);

                if (freq == 1) hashMap.remove(key);
                else {
                    hashMap.put(key, freq - 1);
                    count++;
                }

                start++;
            }

            if (hashMap.size() == k) count++;

        }

        return count;
    }

    public static int myAtoi(String s) {
        long result = 0;
        boolean isNegative = false;
        int idx = 0;

        s = s.strip();
        if (idx < s.length()) {
            if (s.charAt(idx) == '-') {
                isNegative = true;
                idx++;
            } else if (s.charAt(idx) == '+') {
                idx++;
            }
        }

        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (ch >= '0' && ch <= '9') {
                result = (result * 10) + (ch - '0');
                if (result > Integer.MAX_VALUE) {
                    if (isNegative) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
            } else break;
            idx++;
        }

        if (isNegative) return -1 * (int) result;
        return (int) result;
    }

    public int romanToInt(String s) {
        int result = singleRomanToInt(s.charAt(s.length() - 1));

        for (int i = s.length()-2; i >= 0; i--) {
            int num = singleRomanToInt(s.charAt(i));
            int numPrev = singleRomanToInt(s.charAt(i+1));

            if (num >= numPrev) {
                result += num;
            } else {
                result -= num;
            }

        }
        return result;
    }

    public int singleRomanToInt(Character ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return -1;
    }


    public int maxDepth(String s) {
        int max = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '(') {
                res++;
                max = Math.max(max, res);
            } else if (ch == ')') {
                res--;
            }
        }

        return max;
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.merge(s.charAt(i), 1, Integer::sum);
        }

        // sort the hashmap by value
        return "";
    }
}
