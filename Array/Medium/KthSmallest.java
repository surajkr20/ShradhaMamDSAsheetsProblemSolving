package Array.Medium;

import java.util.Collections;
import java.util.PriorityQueue;

// gfg question.Kth smallest element = https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

public class KthSmallest {
    // optimal approach with o(n) t.c and s.c
    public static int kthSmallest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: arr){
            maxHeap.add(num);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
    }
}
