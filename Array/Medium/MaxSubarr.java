package Array.Medium;

public abstract class MaxSubarr {
    // brute force approach
    public static int maxSubArray(int[] nums) {
        int maxsum = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += nums[k];
                }
                maxsum = Math.max(maxsum, sum);
            }
        }
        return maxsum;
    }
    // better solution, time complexity = o(n)
    public static int maxSubArray02(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        if(nums.length == 0) return 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > maxsum) maxsum = sum;
            if(sum < 0) sum = 0;
        }
        return maxsum;
    }
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
