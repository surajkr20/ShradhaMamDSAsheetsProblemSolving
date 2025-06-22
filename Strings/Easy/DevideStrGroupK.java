import java.util.ArrayList;
import java.util.Arrays;

// leetcode.2138. Divide a String Into Groups of Size k = https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/?envType=daily-question&envId=2025-06-22

public class DevideStrGroupK {
    // approach.1 = t.c - o(n * k)
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();
        int i = 0;
        while(i < n){
            int j = Math.min(i+k, n);
            ans.add(s.substring(i,j));
            i += k;
        }

        String lastStr = ans.get(ans.size()-1);
        if(lastStr.length() < k){
            lastStr += String.valueOf(fill).repeat(k - lastStr.length());
            ans.set(ans.size()-1, lastStr);
        }

        return ans.toArray(new String[0]);
    }

    // approach.2 = 
    public static String[] divideString02(String s, int k, char fill){
        StringBuilder str = new StringBuilder(s);
        while(str.length() % k != 0){
            str.append(fill);
        }
        ArrayList<String> ans = new ArrayList<>();
        int curr = 0;
        int n = str.length();
        while(curr < n){
            int end = Math.min(curr+k, n);
            ans.add(str.substring(curr, end));
            curr += k;
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String str = "abcdefghij";
        char fill = 'x';
        System.out.println(Arrays.toString(divideString(str, 3, fill)));
        divideString02(str, 3, fill);
    }
}