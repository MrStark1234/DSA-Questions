// https://leetcode.com/problems/combination-sum/description/

// sort the candidates array and remove unique elements. 
// this way duplicate answers can be avoided. if candidates[i] < t 
// add it to the output array. and recursive call the function 
// for t - c[i] and from the current index of candidates so 
// to avoid duplicate answers. once t reaches 0 add the output 
// to ans.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> output = new ArrayList<>();
        solve(candidates, target, ans, output, 0);
        return ans;
    }

    private void solve(int[] c, int t, List<List<Integer>> ans, List<Integer> output, int index) {
        if (t <= 0) {
            if (t == 0) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        for (int i = index; i < c.length; i++) {
            if (c[i] > t)
                break;
            output.add(c[i]);
            solve(c, t - c[i], ans, output, i);
            output.remove(output.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
    }
}
