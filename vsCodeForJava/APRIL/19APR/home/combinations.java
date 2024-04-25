// https://leetcode.com/problems/combinations/description/

// We have to choose any k numbers from n numbers and return all possible combinations.
// But the numbers should not be repeated. So, we can just use the sorted 
// format of numbers i.e. iterate them in a sorted way so that combinations 
// don’t repeat. We start with 1 and then for each number, we have only two cases ➖
// Take the number
// Skip the number
// And we have to keep in mind that if we have chosen k numbers then 
// push back the current number vector and return.

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> subsets = new ArrayList<>();
        solve(1, n, k, subsets);
        return ans;
    }

    private void solve(int begin, int end, int k, List<Integer> subsets) {
        if (subsets.size() == k) {
            ans.add(new ArrayList<>(subsets));
            return;
        }
        for (int i = begin; i <= end; i++) {
            subsets.add(i);
            solve(i + 1, end, k, subsets);
            subsets.remove(subsets.size() - 1);
        }
    }
}
