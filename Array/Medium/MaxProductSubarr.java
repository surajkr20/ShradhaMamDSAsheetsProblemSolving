package Array.Medium;

// leetcode.ques.152. Maximum Product Subarray = https://leetcode.com/problems/maximum-product-subarray/description/

public class MaxProductSubarr {
    // brute force approach with O(n*n) t.c 
    public static int maxProduct01(int[] nums){
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int product = 1;
            for(int j=i; j<n; j++){
                product *= nums[j];
                maxProd = Math.max(maxProd, product);
            }
        }
        return maxProd;
    }

    // optimal approach with o(n)  time complexity 
    public static int maxProduct02(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;

            pre = pre * nums[i];
            suff = suff * nums[n - i - 1];

            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        System.out.println(maxProduct02(arr));
    }
}