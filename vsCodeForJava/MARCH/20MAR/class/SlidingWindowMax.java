// Link : https://leetcode.com/problems/sliding-window-maximum/

import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int ans[] = new int[n - k + 1];
        int ansId = 0;

        for (int i = 0; i < n; ++i) {
            // Push arr[i] to the deque strategically
            while (q.size() > 0 && arr[q.getLast()] <= arr[i])
                q.removeLast();
            q.addLast(i);

            // If the front element is out of the current
            // window, then pop it out
            if (q.getFirst() <= i - k) {
                q.removeFirst();
            }

            // If we have processed at least k elements
            // add the maximum to the ans appropriately
            if (i >= k - 1) {
                ans[ansId] = arr[q.getFirst()];
                ansId++;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}