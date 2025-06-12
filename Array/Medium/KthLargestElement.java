package Array.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// 215. Kth Largest Element in an Array = https://leetcode.com/problems/kth-largest-element-in-an-array/description/

public class KthLargestElement {
    // brute force approach - t.c - o(n*logn) & s.c - o(1)
    public static int findKthLargest01(int[] nums, int k){
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
    // optimal solution, time and space complexities are o(n).
    public static int findKthLargest02(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    public static void Heaps(int[] arr){
        PriorityQueue<Integer> MinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: arr){
            MinHeap.add(num);
        }
        for(int num: arr){
            MaxHeap.add(num);
        }
        System.out.println(MinHeap.peek());
        System.out.println(MaxHeap.peek());
    }
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        // System.out.println(findKthLargest01(arr, 4));
        Heaps(arr);
    }
}
