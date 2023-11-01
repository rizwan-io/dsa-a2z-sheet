package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class BasicsString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "abced"));
    }


    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }


    public boolean rotateString2(String s, String goal) {
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        while(i<s.length())
        {
            char ch=sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            if(sb.toString().equals(goal))
                return true;
            i++;
        }
        return false;
    }


    // https://leetcode.com/problems/rotate-string/
    public static boolean rotateString(String s, String goal) {
        int sPointer = 0;
        int goalPointer = 0;
        int rotatedBy = 0;

        while (sPointer < s.length()) {
            if (s.charAt(sPointer) == goal.charAt(goalPointer % goal.length())) {
                sPointer++;
                goalPointer++;
            } else {
                sPointer = 0;
                goalPointer = ++rotatedBy;
                while (goalPointer < goal.length()) {
                    if (s.charAt(sPointer) == goal.charAt(goalPointer)) {
                        rotatedBy = goalPointer;
                        break;
                    }
                    goalPointer++;
                }
                if (goalPointer >= goal.length()) return false;
            }
        }

        if (sPointer == s.length()) return true;
        else return false;



    }


    public static boolean isIsomorphic(String s, String t) {
        // Mapping from String s to String t
        HashMap<Character, Character> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                if (t.charAt(i) != hashMap.get(s.charAt(i))) {
                    return false;
                }
            } else if (hashMap.containsValue(t.charAt(i))) {
                return false;
            } else {
                hashMap.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }

    public static String longestCommonPrefixOptimal(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        for (int i = 0; i < Math.min(firstString.length(), lastString.length()); i++) {
            if (firstString.charAt(i) == lastString.charAt(i)) {
                result.append(firstString.charAt(i));
            } else {
                return result.toString();
            }
        }

        return result.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (i > strs[j].length() - 1) return result;
                if (strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    return result;
                }
            }
            result += strs[0].charAt(i);
        }

        return result;
    }

    // 3.
    // https://leetcode.com/problems/largest-odd-number-in-string/
    public static String largestOddNumber(String num) {
        String result = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            // The number is odd
            if (num.charAt(i) % 2  == 1) {
                result = num.substring(0, ++i);
                break;
            }
        }

        return result;
    }

    // 2. Reverse Words in a String
    // https://leetcode.com/problems/reverse-words-in-a-string/description/
    public static String reverseWordsOptimal(String s) {
        return "";
    }

    // 2. Reverse Words in a String
    // https://leetcode.com/problems/reverse-words-in-a-string/description/
    public static String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splitStrings = s.strip().split("\\s+");

        for (int i = splitStrings.length - 1; i >= 0; i--) {
            stringBuilder.append(splitStrings[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    // 1. Remove Outermost Parentheses - Optimal
    // https://leetcode.com/problems/remove-outermost-parentheses/description/
    public static String removeOuterParenthesesOptimal(String s) {
        StringBuilder result = new StringBuilder();
        int opened = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (opened > 0) result.append(c);
                opened++;
            } else {
                if (opened > 1) result.append(c);
                opened--;
            }
        }

        return result.toString();
    }

    // 1. Remove Outermost Parentheses
    // https://leetcode.com/problems/remove-outermost-parentheses/description/
    public static String removeOuterParentheses(String s) {
        int l = 0;
        int h = 0;

        int leftParanthesis = 0;
        int rightParenthesis = 0;

        String result = "";

        while (h < s.length()) {
            if (s.charAt(h) == '(') {
                leftParanthesis++;
            } else {
                rightParenthesis++;
            }

            if (leftParanthesis == rightParenthesis) {
                // remove brackets at l and h position
                for (int i = l+1; i < h; i++) {
                    result += String.valueOf(s.charAt(i));
                }
                l = h + 1;
            }
            h++;
        }
        return result;
    }
}
