/*

Question - Longest Palindromic Subsequence
Link - https://leetcode.com/problems/longest-palindromic-subsequence/description/


Approach-
	This is similar to the Longest Common Subsequence (LCS) problem;
	 the only difference is that LCS involves two strings, whereas here we have only one string.
	 If we create another string by reversing it, then it becomes equivalent to the LCS problem.


*/

// Tabulation 

// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         int[][] dp = new int[n][n];

//         for (int i = n - 1; i >= 0; i--) {
//             dp[i][i] = 1;
//             for (int j = i + 1; j < n; j++) {
//                 if (s.charAt(i) == s.charAt(j)) {
//                     dp[i][j] = dp[i + 1][j - 1] + 2;
//                 } else {
//                     dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                 }
//             }
//         }

//         return dp[0][n - 1];
//     }
// }

// Recursive

import java.util.Arrays;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return res(s, n - 1, 0, dp);
    }

    private int res(String s, int i, int j, int[][] dp) {
        if (i < 0 || j >= s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int op1 = res(s, i - 1, j, dp);
        int op2 = res(s, i, j + 1, dp);
        int op3 = res(s, i - 1, j + 1, dp) + (s.charAt(i) == s.charAt(j) ? 1 : 0);
        return dp[i][j] = Math.max(op1, Math.max(op2, op3));
    }
}
