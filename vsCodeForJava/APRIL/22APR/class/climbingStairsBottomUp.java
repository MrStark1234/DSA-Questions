// Link : https://leetcode.com/problems/climbing-stairs/
// Time : O(N)
// Space : O(N)

import java.util.Arrays;

class Solution {
    // bottom up
    public int climbStairs(int n) {
        int dp[] = new int[n + 2];
        Arrays.fill(dp, -1);
        dp[n] = 1;
        dp[n + 1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }
}