class Solution {
    int MOD = (int) 1e9 + 7;
    int N;
    Integer[][] dp;
    int[] nums;

    public int specialPerm(int[] nums) {
        this.N = nums.length;
        this.dp = new Integer[N][1 << N];
        this.nums = nums;
        return rec(0, 0);
    }

    int rec(int preIndex, int mask) {
        if (mask == (1 << N) - 1)
            return 1;
        if (dp[preIndex][mask] != null)
            return dp[preIndex][mask];
        int count = 0;
        for (int i = 0; i < N; i++)
            if ((mask & (1 << i)) == 0 &&
                    (mask == 0 || nums[i] % nums[preIndex] == 0 || nums[preIndex] % nums[i] == 0))
                count = (count + rec(i, mask | (1 << i))) % MOD;
        return dp[preIndex][mask] = count;
    }
}
