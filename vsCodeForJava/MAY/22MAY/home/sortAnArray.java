// https://leetcode.com/problems/sort-an-array/

// In this problem, we simply push all the elements of 
// the array in the min-heap which have the smallest 
// element at the top. Then we assign the top element 
// of the heap to the first element of the array and 
// remove the top element. We do it for subsequent 
// elements to get the sorted array. 

import java.util.PriorityQueue;

class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
        }

        int i = 0;
        while (!pq.isEmpty()) {
            nums[i++] = pq.poll();
        }

        return nums;
    }
}
