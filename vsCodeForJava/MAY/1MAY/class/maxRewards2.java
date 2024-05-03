import java.util.*;

class Main {
    static int maxRewards(int rew[][], int n, int c) {
        int dp[][] = new int[n][n];
        int lastMax = Integer.MIN_VALUE, lastSecMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            int curMax = Integer.MIN_VALUE, curSecMax = Integer.MIN_VALUE;
            for (int j = 0; j < n; ++j) {
                if (i == 0)
                    dp[i][j] = rew[i][j];
                else {
                    int bestDP = dp[i - 1][j] == lastMax ? lastSecMax : lastMax;
                    dp[i][j] = rew[i][j] + Math.max(dp[i - 1][j], bestDP - c);
                }
                if (dp[i][j] >= curMax) {
                    curSecMax = curMax;
                    curMax = dp[i][j];
                } else if (dp[i][j] >= curSecMax)
                    curSecMax = dp[i][j];
            }
            lastMax = curMax;
            lastSecMax = curSecMax;
        }

        int ans = 0;
        for (int j = 0; j < n; ++j)
            ans = Math.max(ans, dp[n - 1][j]);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int rew[][] = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                rew[i][j] = sc.nextInt();
        System.out.println(maxRewards(rew, n, c));
        sc.close();
    }
}