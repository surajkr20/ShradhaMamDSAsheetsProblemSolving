package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// leetcode.15.3sum = https://leetcode.com/problems/3sum/description/

public class ThreeSum {
    // brute force approach - o(n * log(trip)) time complexity and spacace. c - o(trip)
    public static List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if((nums[i] + nums[j] + nums[k]) == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        ans.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    // better approach - o(n)
    public static List<List<Integer>> threeSumBetter(int[] nums){
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            Set<Integer> seen = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int third = -(nums[i] + nums[j]);
                if(seen.contains(third)){
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplets);
                    result.add(triplets);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }

    // optimal approach - t.c - o(n*n) and sc. o(1)
    public static List<List<Integer>> threeSumOptimal(int[] nums){
         List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // skip duplicates for left and right
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }else if(sum < 0) left++;
                else right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSumBrute(arr));
        System.out.println(threeSumBetter(arr));
    }
}
