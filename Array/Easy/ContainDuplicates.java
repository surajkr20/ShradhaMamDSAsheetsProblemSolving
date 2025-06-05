package Array.Easy;

import java.util.Arrays;
import java.util.HashSet;

// leetcode.217. Contains Duplicate = https://leetcode.com/problems/contains-duplicate/description/

public class ContainDuplicates {
    // brute force approach - t.c = o(nlogn) and s.c = o(1)
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
    // time and space complexities are = o(n)
    public static boolean containsDuplicate02(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        boolean ans = containsDuplicate(arr);
        System.out.println(ans);
    }
}
