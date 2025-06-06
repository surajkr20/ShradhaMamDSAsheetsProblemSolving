package Array.Medium;

// gfg.ques.Chocolate Distribution Problem = https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateDistribution {
    // brute force approach = t.c - O(n logn) & s.c - o(1)
    public static int findMinDiff(ArrayList<Integer> arr, int m) {
        if (m == 0 || arr.size() < m) return 0;

        Collections.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i + m - 1 < arr.size(); i++) {
            int diff = arr.get(i + m - 1) - arr.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7, 3, 2, 4, 9, 12, 56));
        int ans = findMinDiff(list, 3);
        System.out.println(ans);
    }
}