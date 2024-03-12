/*
Q5 - Search a 2D Matrix
Question Link - https://leetcode.com/problems/search-a-2d-matrix/description/

Logic - 
If we concatenate all the rows of the given matrix,
we will get a sorted array. So we can treat this matrix as a sorted array 
with n*m elements and apply standard binary search on it

Time Complexity - O(log(n))
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int target = scanner.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println(obj.searchMatrix(matrix, target));
        }
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0;
        int hi = n * m - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int x = mid / m;
            int y = mid % m;
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
}
