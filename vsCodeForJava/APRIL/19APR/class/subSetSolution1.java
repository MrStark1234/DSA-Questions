// Link : https://leetcode.com/problems/subsets/description/
// Time : O(n * 2^n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Will give us the answer for [0, i];
    @SuppressWarnings({ "rawtypes", "unchecked" })
    List<List<Integer>> subsetsHelper(int[] nums, int i) {
        // Base Case
        if (i == -1) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>());
            return ans;
        }

        List<List<Integer>> partialAns = new ArrayList(subsetsHelper(nums, i - 1));

        // Let's have an empty ans
        List<List<Integer>> ans = new ArrayList<>();

        // Let's copy everything from partial Ans
        for (List<Integer> subset : partialAns) {
            ans.add(new ArrayList(subset));
        }

        // Now, add everything again to the ans,
        // but this time nums[i] should be appended before
        // adding a subset to the ans.
        for (List<Integer> subset : partialAns) {
            List<Integer> newSubset = new ArrayList(subset);
            newSubset.add(nums[i]);
            ans.add(newSubset);
        }

        return ans;
    }

    public List<List<Integer>> subsets(int[] nums) {
        // We need the answer for indices [0, nums.length - 1];
        return subsetsHelper(nums, nums.length - 1);
    }
}