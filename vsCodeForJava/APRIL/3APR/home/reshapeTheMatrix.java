/*
Q3 - Reshape the Matrix
Question Link - https://leetcode.com/problems/reshape-the-matrix/description/

Logic - 
We first convert the indices of n*m into a flattened index.
Then we convert that flattened index into indices for a r*c matrix

Time Complexity - O(n*m)
Space Complexity - O(n*m)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        Solution obj = new Solution();
        int[][] ans = obj.matrixReshape(mat, r, c);
        for (int[] row : ans) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if (n * m != r * c)
            return mat;
        int[][] ans = new int[r][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int flattenedIdx = i * m + j;
                int newRow = flattenedIdx / c;
                int newCol = flattenedIdx % c;
                ans[newRow][newCol] = mat[i][j];
            }
        }
        return ans;
    }
}
