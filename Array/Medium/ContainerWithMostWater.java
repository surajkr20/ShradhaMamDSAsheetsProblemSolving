package Array.Medium;

// leetcode.11. Container With Most Water = https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWithMostWater {
    // brute force approach - t.c o(n^2)
    public static int maxArea(int[] height) {
        int n = height.length;
        int maxwater = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int w = j - i;
                int ht = Math.min(height[i], height[j]);
                int area = w * ht;
                maxwater = Math.max(area, maxwater);
            }
        }
        return maxwater;
    }

    // optimal approach
    public static int maxArea02(int[] height){
        int n = height.length;
        int maxwater = 0;
        int l = 0;
        int r = n - 1;
        while(l < r){
            int w = r - l;
            int ht = Math.min(height[l], height[r]);
            int currwt = w * ht;
            maxwater = Math.max(currwt, maxwater);
            if(height[l] < height[r]) l++;
            else r--;
        }
        return maxwater;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
