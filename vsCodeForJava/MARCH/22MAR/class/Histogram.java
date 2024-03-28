import java.util.*;

// Link : https://leetcode.com/problems/largest-rectangle-in-histogram/

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

    public int largestRectangleArea(int[] heights) {
        int[] next = nextSmaller(heights);
        int[] prev = prevSmaller(heights);

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; ++i)
            ans = Math.max(ans, (next[i] - prev[i] - 1) * heights[i]);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}
