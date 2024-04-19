/*
Question - Maximum Erasure Value (LeetCode)
Link - https://leetcode.com/problems/maximum-erasure-value/description/

Approach:
    This is the same as the previous question, but in this case, we find the sum of elements instead of the length.
    So, we take a variable that will store the current sum of the window.

    Average Time complexity - O(N)
    Space Complexity - O(N)
*/

import java.util.HashMap;
import java.util.Map;

public class MaxErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0, curr_sum = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            curr_sum += nums[j];
            while (mp.get(nums[j]) > 1) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                curr_sum -= nums[i];
                i++;
            }
            ans = Math.max(ans, curr_sum);
            j++;
        }
        return ans;
    }
}
