package Array.Medium;

// leetcode.238. Product of Array Except Self = https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductArrExpectSelf {
    // brute force approach - t.c = o(n*n) and s.c = o(n) 
    public static int[] productExceptSelf01(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int product = 1;
        int  i = 0;
        while(i < n){
            for(int j=0; j<n; j++){
                if(i == j) continue;    // skipping the curr index
                product = product * nums[j];
            }
            ans[i] = product;
            product = 1;    // after first iteration, reset the product value and set to 1
            i++;
        }
        return ans;
    }
    // better approch with o(n) time and space complexties
    public static int[] productExceptSelf02(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Prefix product
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Suffix product
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Final answer
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }
    // optimal approach - t.c = o(n) and s.c = o(1)
    public static int[] productExceptSelf03(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // prefix
        ans[0] = 1;
        for(int i=1; i<n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        // suffix
        int suffix = 1;
        for(int i=n-2; i>=0; i--){
            suffix *= nums[i+1];
            ans[i] *= suffix;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
    }
}
