package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class MinMaxValue {
    public static List<Integer> getMinMax(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min){
                min = arr[i];
            }
        }
        ans.add(max);
        ans.add(min);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 56, 10000, 167};
        System.out.println(getMinMax(arr));
    }
}