/*

Question - Solving Questions With Brainpower
Link - https://leetcode.com/problems/solving-questions-with-brainpower/description/


Approach-
	For each question, we have two options: either take it or skip it.
	 If we take the ith question, then we have to skip questions[i][1] questions. 
	In tabulation, we iterate backward because we need an answer for an index greater than i.


*/

// Tabulation 

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            long take = questions[i][0];
            long skip = 0;

            if (i < n - 1) {
                skip = dp[i + 1];
            }

            if (i + questions[i][1] + 1 < n) {
                take += dp[i + questions[i][1] + 1];
            }

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}

// Recursive

// class Solution {
// public long mostPoints(int[][] questions) {
// int n = questions.length;
// long[] dp = new long[n];
// Arrays.fill(dp, -1);

// return helper(0, questions, dp);
// }

// private long helper(int index, int[][] questions, long[] dp) {
// if (index >= questions.length)
// return 0;
// if (dp[index] != -1)
// return dp[index];

// long take = questions[index][0] + helper(index + questions[index][1] + 1,
// questions, dp);
// long skip = helper(index + 1, questions, dp);

// return dp[index] = Math.max(take, skip);
// }
// }
