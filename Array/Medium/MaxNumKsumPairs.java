package Array.Medium;

import java.util.Arrays;
import java.util.HashMap;

// leetcode.1679. Max Number of K-Sum Pairs = https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

public class MaxNumKsumPairs {
    public static int maxOperations01(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = k - num;
            if (map.getOrDefault(complement, 0) > 0) {
                count++;
                map.put(complement, map.get(complement) - 1); // Use one instance
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1); // Add current num to map
            }
        }

        return count;
    }

    // optimal approach = t.c - O(nlogn) and s.c - o(1)
    public static int maxOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                count++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < k)
                left++;
            else
                right--;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 3, 4, 3 };
        int k = 6;
        System.out.println(maxOperations(arr, k));
    }
}
