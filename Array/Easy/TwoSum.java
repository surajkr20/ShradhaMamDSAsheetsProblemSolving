package Array.Easy;

// leetcode.ques.1. Two Sum = https://leetcode.com/problems/two-sum/description/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // brute force approach - t.c = o(n^2) and s.c - o(1)
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for(int j=i+1; j<n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    // optimal approach - t.c and s.c o(n)
    public static int[] twoSum02(int[] nums, int target){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(nums[i], i);
        }

        for(int i=0; i<n; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSum02(arr, target)));
    }
}
