package Array.Medium;

import java.util.Arrays;

// leetcode.ques.31. Next Permutation = https://leetcode.com/problems/next-permutation/description/

public class NextPermutations {
    private static void reverse(int[] nums, int start, int end){
        int n = nums.length;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    // optimal approach = time compelxity is o(n) and space complexity is o(1)
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        // step.1 = find the pivot
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){    // if pivot is not found
            reverse(nums, 0, n-1);
            return;
        }

        // step2. = finding next greater
        for(int i=n-1; i>pivot; i--){
            if(nums[i] > nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        // step.3 = Reverse the suffix (part after pivot)
        reverse(nums, pivot+1, n-1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
