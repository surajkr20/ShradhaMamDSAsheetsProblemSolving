package Array.Medium;

// leetcode.ques.33.search in rotated sorted array = https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchRotatedArr {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // Standard binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents integer overflow

            // If mid element is the target, return its index
            if (nums[mid] == target)
                return mid;

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // If target lies in the left sorted half
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1; // Move to left half
                } else {
                    low = mid + 1; // Move to right half
                }
            }
            // Otherwise, right half must be sorted
            else {
                // If target lies in the right sorted half
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1; // Move to right half
                } else {
                    high = mid - 1; // Move to left half
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 2;
        System.out.println(search(arr, target));
    }
}
