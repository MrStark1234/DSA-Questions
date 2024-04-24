
// Link : https://leetcode.com/problems/climbing-stairs/
// Time : O(N)
// Space : O(N)
import java.util.Arrays;

class Solution {
    int dp[];

    int climbStairsUtil(int n) {
        if (n == 0 || n == 1) // Base Cases
            return 1;

        if (dp[n] != -1) // memoization
            return dp[n];

        // Let's let our first climb be of 1 step
        int oneCnt = climbStairsUtil(n - 1);

        // Let's let our first climb be of 2 steps
        int twoCnt = climbStairsUtil(n - 2);

        dp[n] = oneCnt + twoCnt;
        return dp[n];
    }

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsUtil(n);
    }
}
