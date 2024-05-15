/*
Q2 - Ilya and Escalator
Question Link - https://codeforces.com/problemset/problem/518/D

DP State: dp[i][j] = probability of having j people in the escalator after t seconds
Final Ans: dp[t][1]*1 + dp[t][2]*2.........dp[t][n]*n

Transitions:
    1. When j==0: dp[i][j] = dp[i-1][j]*(1-p)
    2. When j==n: dp[i][j] = dp[i-1][j-1]*p + dp[i-1][j]
    3. Otherwise: dp[i][j] = dp[i-1][j-1]*p + dp[i-1][j]*(1-p);

Time Complexity: O(n*t)
Space Complexity: O(n*t)
*/

import java.util.Scanner;

public class IlyaAndEscalator {

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of steps on the escalator
        double p = scanner.nextDouble(); // probability of a person taking a step
        int t = scanner.nextInt(); // number of seconds
        double[][] dp = new double[t + 1][n + 1]; // DP array to store probabilities

        dp[0][0] = 1; // Base case: Initially, no one is on the escalator

        // Filling up the DP table
        for (int i = 1; i <= t; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - p); // Transition when there are no people on the escalator
            for (int j = 1; j <= n; j++) {
                if (j == n)
                    dp[i][j] = dp[i - 1][j - 1] * p + dp[i - 1][j]; // Transition when the escalator is full
                else
                    dp[i][j] = dp[i - 1][j - 1] * p + dp[i - 1][j] * (1 - p); // General transition
            }
        }

        // Calculating the final answer
        double ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dp[t][i] * i;
        }
        System.out.printf("%.12f\n", ans); // printing the answer with precision
        scanner.close();
    }

    public static void main(String[] args) {
        solve();
    }
}
