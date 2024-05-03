// Atcoder - C - Vacation
// https://atcoder.jp/contests/dp/tasks/dp_c

import java.util.*;

public class atcoderCVacation {

    public static int helper(int ind, int prev_done, int n, int[][] arr, int[][] dp) {
        // base case
        if (ind == n)
            return 0;

        if (dp[ind][prev_done] != -1)
            return dp[ind][prev_done];

        int max_val = 0;
        // Choose any if you haven't done anything before
        if (prev_done == 0) {
            max_val = Math.max(max_val, arr[ind][1] + helper(ind + 1, 1, n, arr, dp));
            max_val = Math.max(max_val, arr[ind][2] + helper(ind + 1, 2, n, arr, dp));
            max_val = Math.max(max_val, arr[ind][3] + helper(ind + 1, 3, n, arr, dp));
        } else if (prev_done == 1) {
            max_val = Math.max(max_val, arr[ind][2] + helper(ind + 1, 2, n, arr, dp));
            max_val = Math.max(max_val, arr[ind][3] + helper(ind + 1, 3, n, arr, dp));
        } else if (prev_done == 2) {
            max_val = Math.max(max_val, arr[ind][1] + helper(ind + 1, 1, n, arr, dp));
            max_val = Math.max(max_val, arr[ind][3] + helper(ind + 1, 3, n, arr, dp));
        } else {
            max_val = Math.max(max_val, arr[ind][1] + helper(ind + 1, 1, n, arr, dp));
            max_val = Math.max(max_val, arr[ind][2] + helper(ind + 1, 2, n, arr, dp));
        }

        return dp[ind][prev_done] = max_val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(helper(0, 0, n, arr, dp));
        scanner.close();
    }
}
