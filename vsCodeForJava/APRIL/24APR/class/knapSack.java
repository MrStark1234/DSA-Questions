import java.util.*;

// Link : https://atcoder.jp/contests/dp/tasks/dp_d
// Time & Space : O(N*W)

class Main {
    static long[][] dp;

    static long knapsack(int[] w, int[] v, int n, int W) {
        if (n == 0 || W == 0)
            return 0;
        if (dp[n][W] != -1)
            return dp[n][W];
        if (w[n - 1] <= W) { // if (n-1)th item can be taken.
            dp[n][W] = Math.max(v[n - 1] + knapsack(w, v, n - 1, W - w[n - 1]), knapsack(w, v, n - 1, W));
            return dp[n][W];
        }

        dp[n][W] = knapsack(w, v, n - 1, W);
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        dp = new long[n + 1][W + 1];
        for (long[] oneD : dp)
            Arrays.fill(oneD, -1); // Fill the DP with -1

        System.out.println(knapsack(w, v, n, W));
        sc.close();
    }
}