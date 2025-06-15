package Array.Medium;

// my solution link = https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/6845490/efficient-binary-search-approach-find-minimum-in-rotated-sorted-array-java-beats-100/

// leetcode.ques.153. Find Minimum in Rotated Sorted Array = https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

public class MinInRotatedSortArr {
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Min must be in the right part
                low = mid + 1;
            } else {
                // Min could be at mid or left
                high = mid;
            }
        }

        return nums[low]; // or nums[high], both point to min
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }
}
