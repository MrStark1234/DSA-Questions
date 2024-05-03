/*

Question - Burst Balloons
Link - https://leetcode.com/problems/burst-balloons/submissions/1244161606/


Approach-
	For a DP solution to exist, we need to define the subproblems.
	 Let's define the problem first as:solve(nums, i, j)
	 by which I mean that we need to burst balloons starting from index i to index j.
	At the beginning, they'll be 0, nums.size() -1 respectively. 
	Let's suppose we burst the kth balloon in the first chance. 
	We will get nums[k-1] * nums[k] * nums[k+1] coins. 
	Now let's define the subproblems as:
     solve(nums, i, k - 1) , solve(nums, k + 1, j)
     As the balloon k is already burst, we solve the subproblems from i to k -1 and k + 1 to j.
	  But wait, what's going wrong here?
	   The subproblem solve(nums, i, k - 1) and solve(nums, k + 1, j) are not independent since after bursting kth balloon,
	    balloon k - 1 and k + 1 have become adjacent and they will need each other in order to calculate the profit.
		So, as we saw that if we choose the kth balloon to be the first one to be burst, 
		we can't make the subproblems independent. Let's try the other way round. We choose the kth balloon as the last one to be burst.
		 Now the subproblems will become independent since (k - 1)th balloon and (k + 1)th balloon won't need each other in order to calculate the answer.

      Now for each k starting from i to j, we choose the kth balloon to be the last one to be burst and calculate the profit by solving the subproblems recursively.
	   Whichever choice of k gives us the best answer, we store it and return.

*/

// I have added a 1 at the beginning and end to handle edge cases.

// Recursive

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] balloons = new int[n + 2];

        balloons[0] = balloons[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            balloons[i] = nums[i - 1];
        }

        return solve(1, n, balloons, dp);
    }

    private int solve(int i, int j, int[] nums, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int ans = 0;
        for (int k = i; k <= j; k++) {
            int left = solve(i, k - 1, nums, dp);
            int right = solve(k + 1, j, nums, dp);
            int coins = nums[i - 1] * nums[k] * nums[j + 1];
            ans = Math.max(ans, left + right + coins);
        }

        dp[i][j] = ans;
        return ans;
    }
}

// Tabulation

// class Solution {
// public int maxCoins(int[] nums) {
// int n = nums.length;
// int[][] dp = new int[n + 2][n + 2];
// int[] balloons = new int[n + 2];

// balloons[0] = balloons[n + 1] = 1;
// for (int i = 1; i <= n; i++) {
// balloons[i] = nums[i - 1];
// }

// for (int g = 0; g < n; g++) {
// for (int i = 1; i <= n - g; i++) {
// int j = i + g;
// for (int k = i; k <= j; k++) {
// dp[i][j] = Math.max(dp[i][j],
// balloons[i - 1] * balloons[k] * balloons[j + 1] + dp[i][k - 1] + dp[k +
// 1][j]);
// }
// }
// }

// return dp[1][n];
// }
// }
