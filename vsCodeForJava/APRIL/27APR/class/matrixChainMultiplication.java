// Link : https://www.geeksforgeeks.org/problems/matrix-chain-multiplication/1
// Time : O(N^3)

import java.util.Arrays;

class Solution {

    static int matMulHelper(int arr[], int i, int j) { // answer of matrix[i .... j]
        int dp[][] = new int[105][105];
        if (i >= j) // Less than or equal to 1 matrix
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        // Let's assume that last multiplication
        // is like mat[i ... k] * mat[k+1 ... j]
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; ++k) {
            int furtherCost = matMulHelper(arr, i, k) + matMulHelper(arr, k + 1, j);
            int curCost = arr[i - 1] * arr[k] * arr[j];
            dp[i][j] = Math.min(dp[i][j], curCost + furtherCost);
        }
        return dp[i][j];
    }

    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[501][501];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int n = N - 1; // number of matrices
        return matMulHelper(arr, 1, n);
    }
};
