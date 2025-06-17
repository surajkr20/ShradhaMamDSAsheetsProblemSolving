package Array.Medium;

import java.util.Arrays;

// leetcode.16.3sum closest = https://leetcode.com/problems/3sum-closest/

public class ThreeSumClosest {
    // brute force approach - t.c = o(n^3)
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int currSum = nums[i] + nums[j] + nums[k];
                    int currDiff = Math.abs(currSum - target);
                    if (currDiff < minDiff) {
                        res = currSum;
                        minDiff = currDiff;
                    } else if (currDiff == minDiff) {
                        res = Math.max(res, currSum);
                    }
                }
            }
        }
        return res;
    }

    // optimal approach - o(n^2)
    public static int threeSumClosest02(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {

            // Initialize the left and right pointers
            int l = i + 1, r = n - 1;

            while (l < r) {
                int currSum = nums[i] + nums[l] + nums[r];

                if (Math.abs(currSum - target) < minDiff) {
                    minDiff = Math.abs(currSum - target);
                    res = currSum;
                }
                // If multiple sums are closest, take maximum one
                else if (Math.abs(currSum - target) == minDiff) {
                    res = Math.max(res, currSum);
                }

                // If currSum > target then we will decrease the
                // right pointer to move closer to target
                if (currSum > target)
                    r--;

                // If currSum <= target then we will increase the
                // left pointer to move closer to target
                else
                    l++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
