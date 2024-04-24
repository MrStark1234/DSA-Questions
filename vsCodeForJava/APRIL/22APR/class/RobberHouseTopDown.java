// Link : https://leetcode.com/problems/house-robber/
// Time : O(N)
// Space : O(N)

import java.util.Arrays;

class Solution { // top down

    int robUtil(int[] nums, int n, int dp[]) {
        if (n >= nums.length)
            return 0;
        if (dp[n] != -1) // memoization step
            return dp[n];

        int ans1 = 0;
        int ans2 = 0;
        ans1 += nums[n];
        ans1 += robUtil(nums, n + 2, dp);

        ans2 += robUtil(nums, n + 1, dp);

        return dp[n] = Math.max(ans1, ans2);

    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return robUtil(nums, 0, dp);
    }
}