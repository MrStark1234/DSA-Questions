//https://leetcode.com/problems/unique-paths/

import java.util.Arrays;

class Solution {
    int uniquePathHelper(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i >= m || j >= n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int pathFormRight = uniquePathHelper(i, j + 1, m, n, dp);
        int pathFormDown = uniquePathHelper(i + 1, j, m, n, dp);
        return dp[i][j] = pathFormRight + pathFormDown;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePathHelper(0, 0, m, n, dp);
    }
}