package Array.Medium;

import java.util.Arrays;

// leetcode.189. Rotated Array by k times = https://leetcode.com/problems/rotate-array/

public class RotateArr {
    public static void rotate(int[] nums, int k){
        int n = nums.length;
        int[] temp = new int[n];
        for(int i=0; i<n; i++){
            temp[((i+k)%n)] = nums[i];
        }
        // copy the temp values in original arr(nums)
        int i = 0;
        for(int val: temp){
            nums[i] = val;
            i++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int k = 2;
        System.out.println(Arrays.toString(arr));
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
    }
}
