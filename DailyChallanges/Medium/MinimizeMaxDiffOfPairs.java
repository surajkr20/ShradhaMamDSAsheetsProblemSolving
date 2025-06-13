package DailyChallanges.Medium;

import java.util.Arrays;

// leetcode.2616. Minimize the Maximum Difference of Pairs = https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/?envType=daily-question&envId=2025-06-13

public class MinimizeMaxDiffOfPairs {
    private static boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        return count >= p;
    }

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFormPairs(nums, p, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,1,3};
        int p = 2; // max pairs
        System.out.println(minimizeMax(arr, p));
    }
}
