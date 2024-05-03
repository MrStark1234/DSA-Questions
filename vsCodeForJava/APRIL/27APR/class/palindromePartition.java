// Link : https://leetcode.com/problems/palindrome-partitioning-ii/
// Time : O(N^2)

import java.util.Arrays;

class Solution {
    int dp1[][];
    int dp2[];

    int isPal(String s, int i, int j) {
        if (i >= j) // Base Case
            return 1;
        if (dp1[i][j] != -1) // Memoization
            return dp1[i][j];
        return dp1[i][j] = s.charAt(i) == s.charAt(j) && isPal(s, i + 1, j - 1) == 1 ? 1 : 0;
    }

    int minCutHelp(String s, int i) {
        if (i >= s.length() || isPal(s, i, s.length() - 1) == 1) // Base Case
            return 0;
        if (dp2[i] != -1) // Memoization
            return dp2[i];
        dp2[i] = Integer.MAX_VALUE;
        for (int k = i; k + 1 < s.length(); ++k) {
            if (isPal(s, i, k) == 0)
                continue;
            dp2[i] = Math.min(dp2[i], 1 + minCutHelp(s, k + 1));
        }
        return dp2[i];
    }

    public int minCut(String s) {
        dp1 = new int[s.length()][s.length()];
        dp2 = new int[s.length()];
        for (int row[] : dp1)
            Arrays.fill(row, -1);
        Arrays.fill(dp2, -1);
        return minCutHelp(s, 0);
    }
}
