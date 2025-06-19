
// leetcode.242. Valid Anagram = https://leetcode.com/problems/valid-anagram/description/

import java.util.HashMap;

public class ValidAnagram {
    // brute force approach - t.c = o(n^2)
    public static boolean isAnagram(String s, String t) {
        int i = 0;
        boolean flag = false;
        while (i < s.length()) {
            char ch1 = s.charAt(i);
            for (int j = 0; j < t.length(); j++) {
                if (ch1 == t.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return false;
            else
                i++;
        }
        return true;
    }

    // optimal approach = t.c - o(n) and s.c - o(1), because max 26 characters (constant space for English alphabet)
    public static boolean isAnagram02(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!counter.containsKey(ch) || counter.get(ch) == 0) return false;
            counter.put(ch, counter.get(ch)-1);
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagarm", t = "nagaram";
        // System.out.println(isAnagram(s, t));

        System.out.println(isAnagram02(s, t));
    }
}
