package Array.Hard;

// leetcode.ques.42. Trapping Rain Water = https://leetcode.com/problems/trapping-rain-water/description/

public class TrappingRainWater {
    // [Naive Approach] Find left and right max for each index - O(n^2) Time and
    // O(1) Space
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            // finding maximum element on the left side
            int left = height[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }
            // finding maximum element on the right side
            int right = height[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, height[j]);
            }

            res += Math.min(left, right) - height[i];
        }

        return res;
    }

    // [Better Approach] Prefix and suffix max for each index - O(n) Time and O(n)
    // Space
    public static int trap02(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // fill left array
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // fill right array
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }

    // optimal approach with o(n) time complexity and o(1) s.c
    public static int trap03(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        int lmax = 0;
        int rmax = 0;

        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    }
}
