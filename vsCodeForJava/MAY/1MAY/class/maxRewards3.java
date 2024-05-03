import java.util.*;

class Main {
    static int maxRewards(int rew[][], int n) {
        int dp[][] = new int[n][n];
        int pre[][] = new int[n][n];
        int suf[][] = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0)
                    dp[i][j] = rew[i][j];
                else {
                    int comingFromLeft = rew[i][j] - j + pre[i - 1][j]; // dp[i-1][k] + k (k <= j);
                    int comingFromRight = rew[i][j] + j + suf[i - 1][j]; // dp[i-1][k] - k (k >= j);
                    dp[i][j] = Math.max(comingFromLeft, comingFromRight);
                }
                pre[i][j] = j == 0 ? dp[i][j] + j : Math.max(pre[i][j - 1], dp[i][j] + j);
            }
            for (int j = n - 1; j >= 0; --j) {
                suf[i][j] = j == n - 1 ? dp[i][j] - j : Math.max(suf[i][j + 1], dp[i][j] - j);
            }
        }

        int ans = 0;
        for (int j = 0; j < n; ++j)
            ans = Math.max(ans, dp[n - 1][j]);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rew[][] = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                rew[i][j] = sc.nextInt();
        System.out.println(maxRewards(rew, n));
        sc.close();
    }
}