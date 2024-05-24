// Link : https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if (pq.size() < k)
                pq.add(num);
            else if (num > pq.peek()) {
                pq.remove();
                pq.add(num);
            }
        }

        return pq.peek();
    }
}