// Link : https://leetcode.com/problems/permutations/
// Time : O(N * N!)

import java.util.ArrayList;
import java.util.List;

class Solution {
    void swapIndices(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Permutes all the elements in the index range [i, ans.length - 1]
    void permuteHelper(int[] nums, List<List<Integer>> ans, int i) {
        if (i == nums.length) { // push the current permutation to ans
            List<Integer> numList = new ArrayList<>();
            for (int num : nums)
                numList.add(num);
            ans.add(numList);
            return;
        }

        // Try all the elements in the index range [i, ans.length - 1]
        for (int tryId = i; tryId < nums.length; ++tryId) {
            swapIndices(nums, i, tryId);
            permuteHelper(nums, ans, i + 1);
            swapIndices(nums, i, tryId); // Backtracking
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteHelper(nums, ans, 0);
        return ans;
    }
}