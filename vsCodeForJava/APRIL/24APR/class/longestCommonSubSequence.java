//https://leetcode.com/problems/longest-common-subsequence/

import java.util.Arrays;

class Solution {
    int longestCommonSubsequenceHelper(int i, int j, String text1, String text2, int[][] dp) {
        if (i == text1.length() || j == text2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + longestCommonSubsequenceHelper(i + 1, j + 1, text1, text2, dp);
        } else {
            int op1 = longestCommonSubsequenceHelper(i + 1, j, text1, text2, dp);
            int op2 = longestCommonSubsequenceHelper(i, j + 1, text1, text2, dp);
            return dp[i][j] = Math.max(op1, op2);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[1001][1001];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return longestCommonSubsequenceHelper(0, 0, text1, text2, dp);
    }
}

public class longestCommonSubSequence {

}
