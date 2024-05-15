// https://leetcode.com/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/description/

public class numberOfStringWhichCanBeRearrangedToContainSubString {
    int mod = 1000000007;
    int[][][][] dp;

    public int stringCount(int n) {
        dp = new int[n + 1][2][3][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        int ans = fun(0, n, 0, 0, 0) % mod;
        return ans;
    }

    public int fun(int i, int n, int l, int e, int t) {
        if (i == n) {
            if (l == 1 && e >= 2 && t == 1)
                return 1;
            return 0;
        }
        if (dp[i][l][e][t] != -1)
            return dp[i][l][e][t];
        int ans = fun(i + 1, n, l, e, t) % mod;
        ans = (int) (((long) ans * 23) % mod);
        ans = (ans + fun(i + 1, n, Math.min(l + 1, 1), e, t) % mod) % mod;
        ans = (ans + fun(i + 1, n, l, Math.min(e + 1, 2), t) % mod) % mod;
        ans = (ans + fun(i + 1, n, l, e, Math.min(t + 1, 1)) % mod) % mod;
        return dp[i][l][e][t] = ans;
    }
}
