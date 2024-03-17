// Link : https://www.geeksforgeeks.org/problems/next-larger-element/1

// Time : O(N)
// Space : O(N)

import java.util.Stack;

class Solution {
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> s = new Stack<>();
        long ans[] = new long[n];
        for (int i = n - 1; i >= 0; --i) {
            while (s.empty() == false && s.peek() <= arr[i])
                s.pop();
            ans[i] = s.empty() == true ? -1 : s.peek();
            s.push(arr[i]);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}
