import java.util.*;

class Main {
    static int setBits(int m) {
        int ans = 0;
        while (m > 0) {
            ans++;
            m &= (m - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            // [0, 1, 2, ..... n - 1];

            int rew[][] = new int[n][n];

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    rew[i][j] = sc.nextInt();

            int dp[] = new int[1 << n];

            for (int m = 1; m < (1 << n); ++m) {
                int id = setBits(m) - 1;
                for (int i = 0; i < n; ++i) {
                    if (((m >> i) & 1) > 0) {
                        int curRew = rew[i][id];
                        int furtherRew = dp[m ^ (1 << i)];
                        dp[m] = Math.max(dp[m], curRew + furtherRew);
                    }
                }
            }

            System.out.println(dp[(1 << n) - 1]);
        }
    }
}