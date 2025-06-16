package Array.Medium;

import java.util.HashSet;

// gfg.question.Pair Sum in a Sorted and Rotated Array = https://www.geeksforgeeks.org/problems/pair-sum-in-a-sorted-and-rotated-array/1

public class PairSumRotatedSortedArr {
    // brute force approach using hasing - time and space complexities are o(n)
    static boolean pairInSortedRotated(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (set.contains(complement))
                return true;
            set.add(arr[i]);
        }
        return false;
    }

    // optimal approach
    static boolean pairInSortedRotated02(int[] arr, int target) {
        int n = arr.length;
        // finding pivot element
        int i;
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                break;
        }
        int l = (i + 1) % n;
        int r = i;

        // searching pairs in arr, there addition is equal to the target
        while (l != r) {
            if (arr[l] + arr[r] == target)
                return true;
            if (arr[l] + arr[r] < target) {
                l = (l + 1) % n;
            } else {
                r = (r - 1 + n) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 9, 1, 3, 5 };
        int target = 6;

    }
}
