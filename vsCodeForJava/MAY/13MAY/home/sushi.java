/*
Q3 - Sushi
Question Link - https://atcoder.jp/contests/dp/tasks/dp_j

DP State: dp[i][j][k] = expectation value to finish the game when there are:
                        -> i plates with 1 sushi
                        -> j plates with 2 sushi
                        -> k plates with 3 sushi
Final Ans: dp[cnt[1]][cnt[2]][cnt[3]]

Transitions:
    dp[i][j][k] -> dp[i-1][j][k] with probability (i/n)
    dp[i][j][k] -> dp[i+1][j-1][k] with probability (j/n)
    dp[i][j][k] -> dp[i][j+1][k-1] with probability (k/n)

Time Complexity: O(n^3)
Space Complexity: O(n^3)
*/

import java.util.Arrays;
import java.util.Scanner;

public class sushi {

    static int n;
    static final int maxN = 300;
    static double[][][] dp = new double[maxN + 1][maxN + 1][maxN + 1];
    static boolean[][][] vis = new boolean[maxN + 1][maxN + 1][maxN + 1];

    static double ev(int c1, int c2, int c3) {
        if (c1 == 0 && c2 == 0 && c3 == 0)
            return 0;
        if (vis[c1][c2][c3])
            return dp[c1][c2][c3];
        double ans = 1;
        if (c1 > 0)
            ans += ((1.0) * c1 / n) * ev(c1 - 1, c2, c3);
        if (c2 > 0)
            ans += ((1.0) * c2 / n) * ev(c1 + 1, c2 - 1, c3);
        if (c3 > 0)
            ans += ((1.0) * c3 / n) * ev(c1, c2 + 1, c3 - 1);
        double p0 = ((1.0) * n - c1 - c2 - c3) / n;
        ans /= (1 - p0);
        vis[c1][c2][c3] = true;
        return dp[c1][c2][c3] = ans;
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            cnt[x]++;
        }
        for (double[][] layer2D : dp)
            for (double[] layer1D : layer2D)
                Arrays.fill(layer1D, -1); // initializing dp array with -1
        System.out.printf("%.12f", ev(cnt[1], cnt[2], cnt[3]));
        scanner.close();
    }

    public static void main(String[] args) {
        solve();
    }
}
