package Recursion.Basics;

import java.util.Arrays;

public class ReverseArr {
    private static void reverse(int[] nums, int i, int j){
        if(i > j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++; j--;
        reverse(nums, i, j);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}
