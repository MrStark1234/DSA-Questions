// Leetcode - 85. Maximal Rectangle
// https://leetcode.com/problems/maximal-rectangle/description/
/*
  
convert matrix into histogram

Intuition

The problem asks us to find the rectangle with the largest area that 
consists entirely of 1s in a binary matrix. Here's an intuitive approach:

Think horizontally: 
   For each row, imagine stacking 1s vertically. We can treat this as a histogram 
   where the height of each bar represents the number of consecutive 1s in the current row.
   Find maximal area in a histogram: We know efficient algorithms (like the 
   stack-based approach) to find the largest rectangle within a histogram.

Approach

Build row-wise histograms: 
   Iterate through the matrix. For each row, create a new histogram array to keep 
   track of the number of consecutive 1s encountered so far for each column. If a 0 is
   encountered, reset the count to 0.
   consider below example-
    [0,1,1,0,1]
	[1,1,0,1,0]
	[0,1,1,1,0]
	[1,1,1,1,0]
	[1,1,1,1,1]
	[0,0,0,0,0]

   For each row the histogram array will be 
	[0,1,1,0,1]
	[1,2,0,1,0]
	[0,3,1,2,0]
	[1,4,2,3,0]
	[2,5,3,4,1]
	[0,0,0,0,0]

Process each histogram: 
    For each row's histogram, apply the findLargestAreaInHistogram function to determine 
	the maximum rectangle area that can be formed using the heights in that row.

Track global maximum: 
    Maintain a variable area to keep track of the largest rectangle area found so far 
	across all rows. Update area with the maximum area calculated for each row's histogram.

*/

import java.util.Stack;

class Solution {
    int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            ans[i] = s.empty() ? -1 : s.peek();
            s.push(i);
        }
        return ans;
    }

    int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            ans[i] = s.empty() ? n : s.peek();
            s.push(i);
        }
        return ans;
    }

    public int findLargestAreaInHistogram(int[] heights) {
        int[] next = nextSmaller(heights);
        int[] prev = prevSmaller(heights);

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; ++i)
            ans = Math.max(ans, (next[i] - prev[i] - 1) * heights[i]);
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int area = 0;

        // First, make the histogram row-wise
        int[] rowHistogram = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == '1') {
                    rowHistogram[j]++;
                } else {
                    rowHistogram[j] = 0;
                }
            }
            // Now I have created the histogram for the particular level
            // Now find the largest area in that level
            area = Math.max(area, findLargestAreaInHistogram(rowHistogram));
        }
        return area;
    }
}
