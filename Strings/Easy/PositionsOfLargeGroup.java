import java.util.ArrayList;
import java.util.List;

// leetcode.830.830. Positions of Large Groups = https://leetcode.com/problems/positions-of-large-groups/description/

public class PositionsOfLargeGroup {
    public static List<List<Integer>> largeGroupPositions(String s){
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        int i = 0; int j = 0;
        while(j < n){
            while(j < n && s.charAt(i) == s.charAt(j)){
                j++;
            }
            if(j - i >= 3){
                ans.add(List.of(i, j-1));
            }
            i = j;
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "abcdddeeeeaabbbcd";
        System.out.println(largeGroupPositions(str));
    }
}
