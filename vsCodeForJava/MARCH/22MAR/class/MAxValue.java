import java.util.*;

// Link : https://leetcode.com/problems/max-value-of-equation/

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int finalAns = Integer.MIN_VALUE;
        // Iterate on all j values.
        for (int j = 0; j < points.length; ++j) {
            // Pop the ones that are invalid
            // now & have gone out of the window
            while (!q.isEmpty() && points[q.peekFirst()][0] < points[j][0] - k)
                q.removeFirst();

            // If there is a valid i left
            if (!q.isEmpty()) {
                int i = q.peekFirst();
                int curAns = points[i][1] + points[j][1] + points[j][0] - points[i][0];
                finalAns = Math.max(finalAns, curAns);
            }

            // Adding afterwards because
            // i < j, and not i <= j
            int y_minus_x = points[j][1] - points[j][0];
            while (!q.isEmpty() && points[q.peekLast()][1] - points[q.peekLast()][0] <= y_minus_x)
                q.removeLast();
            // then push the current index.
            q.addLast(j);
        }
        return finalAns;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}