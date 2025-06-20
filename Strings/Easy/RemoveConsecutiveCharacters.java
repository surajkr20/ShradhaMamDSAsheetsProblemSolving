
// Remove Consecutive Characters = https://www.geeksforgeeks.org/problems/consecutive-elements2306/1

public class RemoveConsecutiveCharacters {
    public static String removeConsecutiveCharacter(String s) {
        int n = s.length();
        if (s == null || n == 0)
            return "";
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));

        for(int i=1; i<n; i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i-1);

            if(ch1 != ch2){
                result.append(ch1);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(removeConsecutiveCharacter(s));
    }
}
