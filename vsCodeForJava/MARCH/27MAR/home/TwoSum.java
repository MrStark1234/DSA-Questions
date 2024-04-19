/*
Question - Two Sum(LeetCode)
Link - https://leetcode.com/problems/two-sum/description/

Approach- A  efficient approach is to use a hash table (unordered_map in C++).
		  We can iterate through the array once, and for each element,
		  check if the target minus the current element exists in the hash table.
		  If it does, we have found a valid pair of numbers. 
		  If not, we add the current element to the hash table.

		  Average Time complexity- O(N) 
		  Space Complexity - O(N)
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }

        return new int[] {}; // No solution found
    }
}
