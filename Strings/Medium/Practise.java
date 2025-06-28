package Strings.Medium;

public class Practise {
    // logest substring without repeating character
    public static int LongestSubstring(String s){
        int left = 0,  right = 0;
        int maxLen = 0;
        int[] freq = new int[256];
        while(right < s.length()){
            char current = s.charAt(right);
            freq[current]++;

            // if there's a duplicate, shrink the window size
            while(freq[current] > 1){
                freq[s.charAt(left)]--;
                left++;
            }

            // update the max length of valid substring
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }

    public static int characterReplacement(String s, int k){
        int maxLen = 0; // store total length of valid substring after replacements

        for(int i=0; i<s.length(); i++){
            int[] freq = new int[256];
            for(int j=i; j<s.length(); j++){
                freq[s.charAt(j) - 'A']++;
                int len = j - i + 1;    // current possible substrings length

                int maxFreq = 0;
                for(int f : freq){
                    maxFreq = Math.max(maxLen, f);
                }

                int replacement = len - maxFreq;

                if(replacement <= k){
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "acab";
        int k = 2;
        System.out.println(LongestSubstring(s));

        System.out.println(characterReplacement(s, k));
    }
}
