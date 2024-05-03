// Leetcode- 120. Triangle
// https://leetcode.com/problems/triangle/description/

/*

The wording is tricky, but take my word for it that "adjacent" means 
that you can move down by 1, or down and to the right by 1. This being the case, 
we need to calculate every possible path from the starting node to one of the 
bottom nodes. Take this triangle for example:
1
2 3
4 5 6

There are 4 paths:
1 2 4
1 2 5
1 3 5
1 3 6

The minimum sum path is 1 2 4.
At each node, we can make at most 2 different moves. 
Let's start from the bottom and move up towards the top.

*/

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Initialize the bottom row of dp with the values from the triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Iterate through the triangle rows in bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the minimum path sum for the current cell
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // now top-left cell of dp contains the minimum path sum
        return dp[0][0];
    }
}
