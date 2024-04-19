// leetcode- 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = map.size();
        int[][] arr = new int[n][2];

        int idx = 0;
        for (Integer i : map.keySet()) {
            arr[idx][1] = i;
            arr[idx][0] = map.get(i);
            idx++;
        }
        // sort it by frequencies
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // put top k frequent elements in the final array
        int[] res = new int[k];
        idx = 0;

        for (int i = n - 1; i >= n - k; i--) {
            res[idx++] = arr[i][1];
        }
        return res;
    }
}