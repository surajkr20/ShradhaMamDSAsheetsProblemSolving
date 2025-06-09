package Array.Easy;

// leetcode.1752. Check if Array Is Sorted and Rotated = https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

public class CheckArrSortedRotated {
    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=1; i<n; i++){
            if(nums[i-1] > nums[i]) count++;
        }
        if(nums[n-1] > nums[0]) count++;
        if(count <= 1) return true;
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(check(arr));
    }
}
