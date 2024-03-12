// https://leetcode.com/problems/sum-in-a-matrix/description/

// Sort the matrix on each row.
// Then traverse the matrix column wise and keep adding the max value on each column to ans.

import java.util.Arrays;

public class sumInAMatrix {
    public int matrixSum(int[][] nums) {
        int ans = 0;

        for (int[] row : nums) {
            Arrays.sort(row);
        }

        for (int c = 0; c < nums[0].length; ++c) {
            int t = 0;
            for (int[] row : nums) {
                t = Math.max(t, row[c]);
            }
            ans += t;
        }

        return ans;
    }
}