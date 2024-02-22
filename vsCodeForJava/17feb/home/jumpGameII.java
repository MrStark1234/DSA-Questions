/*
Intuition
intuitive solve easy cpp

Approach
create an array to store the minimum steps till that positions

Complexity
Time complexity:
O(n^2)

Space complexity:
O(n) extra space for the arrays
*/

import java.util.Arrays;

class jumpGameII {
    public int jump(int[] nums) {
        int[] A = nums.clone();
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= Math.min(n - 1, i + A[i]); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        if (dp[n - 1] == Integer.MAX_VALUE)
            return -1;
        return dp[n - 1];
    }
}
