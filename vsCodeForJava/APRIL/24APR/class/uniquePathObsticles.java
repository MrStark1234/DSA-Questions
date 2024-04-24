// Link : https://leetcode.com/problems/unique-paths-ii/
// Time & Space : O(M*N)

import java.util.Arrays;

class Solution {
    public int uniquePathsWithObstaclesHelper(int i, int j, int m, int n, int[][] dp, int[][] obstacleGrid) {
        if (i >= m || j >= n)
            return 0;
        if (obstacleGrid[i][j] == 1)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];

        int pathsFromRight = uniquePathsWithObstaclesHelper(i, j + 1, m, n, dp, obstacleGrid);
        int pathsFromDown = uniquePathsWithObstaclesHelper(i + 1, j, m, n, dp, obstacleGrid);

        return dp[i][j] = pathsFromRight + pathsFromDown;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[101][101];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return uniquePathsWithObstaclesHelper(0, 0, m, n, dp, obstacleGrid);
    }
}
