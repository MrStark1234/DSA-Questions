// Leetcode-Partition Equal Subset Sum
// https://leetcode.com/problems/partition-equal-subset-sum/description/

/*
To be able to get 2 subsets having equal sum, out of the same array or sequence, 
the very first necessity is that the sum of all the numbers in the array, equals to 
an even number. if sum is odd we cannot devide it into two equal part.

Here in the BASE CASES:
If target == 0, it means that we have already found the subsequence from the previous 
steps, so we can return true.

If ind<0, it means we did not find any sequence so return false;

The next steps written in the function have been implemented using the pick and not pick technique of recursion

*/

import java.util.Arrays;

class Solution {
    public boolean helper(int index, int target, int[] nums, int[][] dp) {
        if (target == 0)
            return true;

        if (index < 0)
            return false;

        if (dp[index][target] != -1)
            return dp[index][target] == 1;

        boolean notTake = helper(index - 1, target, nums, dp);

        boolean take = false;
        if (nums[index] <= target)
            take = helper(index - 1, target - nums[index], nums, dp);

        dp[index][target] = (notTake || take) ? 1 : 0;
        return dp[index][target] == 1;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, target, nums, dp);
    }
}