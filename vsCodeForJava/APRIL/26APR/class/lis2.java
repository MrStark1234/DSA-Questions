// Link : https://leetcode.com/problems/longest-increasing-subsequence/
// Time : O(NlogN)

import java.util.Arrays;

class Solution {
    int lowerBound(int dp[], int val) {
        int beg = 0, end = dp.length - 1, ans = -1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (dp[mid] >= val) {
                ans = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return ans;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int id = lowerBound(dp, nums[i]);
            if (id != -1)
                dp[id] = nums[i];
        }

        int ans = 1;
        while (ans < n && dp[ans + 1] < Integer.MAX_VALUE)
            ans += 1;

        return ans; // largest id s.t. dp[id] != inf;
    }
}