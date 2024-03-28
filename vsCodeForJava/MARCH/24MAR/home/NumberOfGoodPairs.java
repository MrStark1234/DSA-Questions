/*
Question - Number of Good Pairs(Leetcode)
Link  -  https://leetcode.com/problems/number-of-good-pairs/description/


Approch-
	We need to find the number of good pairs {nums[i] == nums[j] and i < j}.
	 To do this, we use a map and a result variable. 
	 We iterate through the array and update the frequency of each element in the map.
	  For a particular index j, we have to find the number of elements that are equal
	   to nums[j] and whose index is less than j.
	    We can count such elements using the map, 
		and this contributes to the final answer.
*/

import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            result += count.getOrDefault(nums[j], 0); // Count of elements equal to nums[j] and whose index is less than
                                                      // j.
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1); // Update the frequency of this element.
        }
        return result;
    }
}
