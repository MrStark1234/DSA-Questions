/*
Q1 - Choosing From Buckets
Question Link - https://www.codechef.com/problems/BUCKETS

DP State: dp[i][j] = probability of choosing ball of colour j from bucket i
Final Ans: dp[n-1][0] dp[n-1][1] ..... dp[n-1][k-1]

Transition: dp[i][j] = (dp[i-1][j]*((v[i][j]+1)/(d+1))) + ((1-dp[i-1][j])*((v[i][j])/(d+1)));
Explanation: Two cases:
    1. if color j was selected from bucket i-1: dp[i-1][j]*((v[i][j]+1)/(d+1))
    2. if some other color was selected form bucket i-1: (1-dp[i-1][j])*((v[i][j])/(d+1))

Base Case: Bucket 0: dp[0][j] = v[0][j]/sum(v[0])

Time Complexity: O(n*k)
Space Complexity: O(n*k)
*/

import java.util.Scanner;

public class chooseTheBucket {

    // Function to solve the problem
    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of buckets
        int k = scanner.nextInt(); // number of colors
        int[][] v = new int[n][k]; // array to store colors in each bucket

        // Inputting the colors in each bucket
        for (int i = 0; i < n; i++)
            for (int j = 0; j < k; j++)
                v[i][j] = scanner.nextInt();

        // 2D array to store DP states
        double[][] dp = new double[n][k];

        // Initializing base case for bucket 0
        int d = 0;
        for (int j = 0; j < k; j++)
            d += v[0][j]; // calculating the sum of colors in bucket 0
        for (int j = 0; j < k; j++)
            dp[0][j] = (1.0 * v[0][j]) / d; // setting probabilities for bucket 0

        // Filling up the DP table
        for (int i = 1; i < n; i++) {
            d = 0;
            for (int j = 0; j < k; j++)
                d += v[i][j]; // calculating the sum of colors in bucket i
            for (int j = 0; j < k; j++) {
                // Transition formula
                dp[i][j] = ((1.0 * dp[i - 1][j]) * ((1.0 * (v[i][j] + 1)) / (d + 1))) +
                        ((1.0 * (1 - dp[i - 1][j])) * ((1.0 * v[i][j]) / (d + 1)));
            }
        }

        // Printing the final answers
        for (int i = 0; i < k; i++) {
            System.out.printf("%.12f ", dp[n - 1][i]); // formatting output to 12 decimal places
            scanner.close();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
