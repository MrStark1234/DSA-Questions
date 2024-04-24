// Link : https://leetcode.com/problems/subsets/description/
// Time : O(n * 2^n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    void subsetsHelper(int[] nums, List<List<Integer>> allSubsets, List<Integer> curSubset, int i) {
        if (i == nums.length) {
            allSubsets.add(new ArrayList(curSubset));
            return;
        }

        // Every i has 2 choices

        // Include it in the subset
        curSubset.add(nums[i]);
        subsetsHelper(nums, allSubsets, curSubset, i + 1);

        // Skip it
        curSubset.remove(curSubset.size() - 1);
        subsetsHelper(nums, allSubsets, curSubset, i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        subsetsHelper(nums, all, cur, 0);
        return all;
    }
}
