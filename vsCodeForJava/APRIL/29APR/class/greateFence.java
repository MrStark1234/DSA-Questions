import java.util.*;
import java.io.*;

// Link : https://codeforces.com/contest/1221/problem/D

public final class greateFence {
    static long getMinCost(int a[], int b[], long dp[][], int i, int j) {
        if (i >= a.length) // no board left
            return 0;
        if (i == a.length - 1) // last board
            return j * (long) b[i];

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Long.MAX_VALUE;

        for (int k = 0; k <= 2; ++k) { // a[i+1] incremented by k
            if (a[i] + j == a[i + 1] + k)
                continue;
            long curCost = j * (long) b[i];
            long futureCost = getMinCost(a, b, dp, i + 1, k);
            dp[i][j] = Math.min(dp[i][j], curCost + futureCost);
        }
        return dp[i][j];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());

            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; ++i) {
                String line[] = r.readLine().split(" ");
                a[i] = Integer.parseInt(line[0]);
                b[i] = Integer.parseInt(line[1]);
            }

            long dp[][] = new long[n][3];

            for (long row[] : dp)
                Arrays.fill(row, -1l);

            long ans = Long.MAX_VALUE;
            for (int i = 0, j = 0; j <= 2; ++j)
                ans = Math.min(ans, getMinCost(a, b, dp, i, j));

            w.print(ans);
            w.print('\n');
        }

        r.close();
        w.close();
    }
}