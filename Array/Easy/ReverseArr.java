package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArr {
    // brute force approach - time and space complexities are = o(n)
    public static void reverseArray(int arr[]) {
        List<Integer> temp = new ArrayList<>();
        for(int i=arr.length-1; i>=0; i--){
            temp.add(arr[i]);
        }
        for(int j=0; j<temp.size(); j++){
            arr[j] = temp.get(j);
        }
    }
    // optimal solution
    public static void reverseArray02(int arr[]) {
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    // recursive approach
    public static void helper(int[] arr, int i, int j){
        if(i > j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        helper(arr, i+1, j-1);
    }
    public static void recursiveArr(int[] arr){
        int n = arr.length;
        int j = n-1;
        helper(arr, 0, j);
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 5};
        System.out.println(Arrays.toString(arr));
        recursiveArr(arr);
        System.out.println(Arrays.toString(arr));
    }
}
