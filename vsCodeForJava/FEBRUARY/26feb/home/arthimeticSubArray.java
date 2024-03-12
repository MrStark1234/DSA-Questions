/*
	https://leetcode.com/problems/arithmetic-subarrays/

	You are given queries in which left end and right end 
	is given, and you have to check whether from nums[l] to nums[r]
	can be rearranged to make an AP.

	To check for AP? We can sort the arrar from l to r, and
	can check if diff of consecutive elements is same or not.

	TC- O(nlogn)
	Sc- O(1)
*/

import java.util.*;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] subarray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            ans.add(check(subarray));
        }

        return ans;
    }

    private boolean check(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}
