// leetcode.ques.680. Valid Palindrome = https://leetcode.com/problems/valid-palindrome-ii/description/

public class ValidPalindromeII {
    private static boolean isPalindrome(String str, int left, int right){
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindrome02(String str){
        int n = str.length();
        int start = 0;
        int end = n-1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return isPalindrome(str, start+1, end) || isPalindrome(str, start, end-1);
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(isPalindrome02(s));
    }
}
