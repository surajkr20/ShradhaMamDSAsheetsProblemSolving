
// leetcode.ques.125. Valid Palindrome = https://leetcode.com/problems/valid-palindrome/description/

public class ValidPalindrome {
    // recursive appraoch
    private static boolean helper(String str, int start, int end){
        if(start > end) return true;
        else if(str.charAt(start) != str.charAt(end)) return false;
        else return helper(str, ++start, --end);
    }
    public static boolean isPalindrome(String s){
        String cleanedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return helper(cleanedStr, 0, cleanedStr.length()-1);
    }

    // iterative approach
    public static boolean isPalindrome02(String s){
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = str.length()-1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)) return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome02(s));
        // isPalindrome(s);
    }
}