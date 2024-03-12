// Subsets
// https://leetcode.com/problems/subsets/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    void recursion(int index, int n, List<Integer> temp, List<List<Integer>> ans, int[] nums1) {
        if (index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        recursion(index + 1, n, temp, ans, nums1);
        temp.add(nums1[index]);
        recursion(index + 1, n, temp, ans, nums1);
        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        recursion(0, n, temp, ans, nums);
        return ans;
    }
}