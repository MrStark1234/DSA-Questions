// Link : https://leetcode.com/problems/subsets/ 

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // iterate over all the bitmasks
        for (int m = 0; m < (1 << n); ++m) {
            List<Integer> curSubset = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (((m >> i) & 1) == 1)
                    curSubset.add(nums[i]);
            }
            ans.add(curSubset);
        }

        return ans;
    }
}