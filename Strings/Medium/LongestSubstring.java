package Strings.Medium;

// leetcode.ques.3. Longest Substring Without Repeating Characters = https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        int[] freq = new int[256];  // to keep track of how many times each characters appear
        int left = 0, right = 0;
        int maxLen = 0;
        while(right < s.length()){
            char current = s.charAt(right);
            freq[current]++;

            // if therer's a duplicate, shrink window from the left
            while(freq[current] > 1){
                freq[s.charAt(left)]--;
                left++;
            }

            // update maxLen of valid window
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
