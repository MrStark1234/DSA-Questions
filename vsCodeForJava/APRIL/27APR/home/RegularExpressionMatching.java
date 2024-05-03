/*

Question - Regular Expression Matching
Link - https://leetcode.com/problems/regular-expression-matching/description/

To implement regular expression matching with support for '.' and '*',
 we can use dynamic programming. 
 We will create a 2D boolean array dp where dp[i][j] will be true if the first
  i characters of s match the first j characters of p, and false otherwise.

*/

//Tabulation
// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int m = p.length();
//         boolean[][] dp = new boolean[n + 1][m + 1];
//         dp[0][0] = true;

//         for (int i = 0; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if (p.charAt(j - 1) == '*') {
//                     dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
//                             && dp[i - 1][j]);
//                 } else {
//                     dp[i][j] = i > 0 && dp[i - 1][j - 1]
//                             && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
//                 }
//             }
//         }

//         return dp[n][m];
//     }
// }

// Recursive

import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, n, m, s, p, dp) == 1;
    }

    private int solve(int pos1, int pos2, int n, int m, String s, String p, int[][] dp) {
        if (pos1 == n && pos2 == m) {
            return 1;
        }
        if (pos2 >= m) {
            return 0;
        }
        if (dp[pos1][pos2] != -1) {
            return dp[pos1][pos2];
        }

        if (pos2 + 1 < m && p.charAt(pos2 + 1) == '*') {
            int okay = solve(pos1, pos2 + 2, n, m, s, p, dp);
            for (int i = pos1; i < n; i++) {
                if (p.charAt(pos2) == s.charAt(i) || p.charAt(pos2) == '.') {
                    okay |= solve(i + 1, pos2 + 2, n, m, s, p, dp);
                } else {
                    break;
                }
            }
            return dp[pos1][pos2] = okay;
        } else if (pos1 < n && (s.charAt(pos1) == p.charAt(pos2) || p.charAt(pos2) == '.')) {
            return dp[pos1][pos2] = solve(pos1 + 1, pos2 + 1, n, m, s, p, dp);
        } else {
            return dp[pos1][pos2] = 0;
        }
    }
}
