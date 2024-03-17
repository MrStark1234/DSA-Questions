// Link : https://www.geeksforgeeks.org/problems/stock-span-problem/1

import java.util.Stack;

class Solution {
    static int[] prevGreaterElements(int nums[], int n) {
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; ++i) {
            while (!s.empty() && nums[s.peek()] <= nums[i])
                s.pop();

            ans[i] = s.empty() ? -1 : s.peek();
            s.push(i);
        }

        return ans;
    }

    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        int pge[] = prevGreaterElements(price, n);
        int ans[] = new int[n];

        for (int i = 0; i < n; ++i)
            ans[i] = i - pge[i];

        return ans;
    }

}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}