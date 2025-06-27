package Strings.Medium;

// 424. Longest Repeating Character Replacement = https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class LongestRepeatingCharReplacement {
    // optimized approach = t.c - o(n * 26) - o(n) & s.c - o(26)
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, right = 0;
        int maxFreq = 0; // max frequency of a single character in window
        int maxLength = 0;

        while (right < s.length()) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;
            int charsToChange = windowSize - maxFreq;

            if (charsToChange > k) {
                freq[s.charAt(left) - 'A']--;
                left++; // shrink window
            } else {
                maxLength = Math.max(maxLength, windowSize);
            }
            right++;
        }

        return maxLength;
    }

    // brute force approach = t.c - o(n^2 * 26) - o(n^2) & s.c - o(26)
    public static int characterReplacement02(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // For A-Z

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'A']++;

                int len = j - i + 1;
                int maxFreq = 0;
                for (int f : freq) {
                    maxFreq = Math.max(maxFreq, f);
                }

                int replacements = len - maxFreq;

                if (replacements <= k) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;

    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
        System.out.println(characterReplacement02(s, k));
    }
}
