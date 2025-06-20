
// leetcode.ques.14. Longest Common Prefix = https://leetcode.com/problems/longest-common-prefix/description/

public class LongestCommonPrefix {
    // brute force approach - Pairwise Comparison — compare characters in adjacent
    // strings to find common length.
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minLen = strs[0].length();

        for (int i = 0; i < strs.length - 1; i++) {
            String first = strs[i];
            String second = strs[i + 1];
            int j = 0;
            int min = Math.min(first.length(), second.length());

            while (j < min) {
                if (first.charAt(j) != second.charAt(j))
                    break;
                j++;
            }

            minLen = Math.min(minLen, j);
        }

        return strs[0].substring(0, minLen);
    }

    // optimized - Horizontal Scanning — shrink the prefix until all strings match.
    public String longestCommonPrefix02(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }
}
