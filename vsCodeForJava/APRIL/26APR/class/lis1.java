// Link : https://leetcode.com/problems/longest-increasing-subsequence/
// Time : O(N^2)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 0;
        int dp[] = new int[n];
        for(int i = 0; i < n; ++i) {
            dp[i] = 1; // because, in the worst case, arr[i] alone can be a subsequence.
            for(int j = 0; j < i; ++j)
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            
            // Take max of all dp values
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}