/*
Q1 - Number of 1 Bits
Question Link - https://leetcode.com/problems/number-of-1-bits/description/

Logic:
We unset the rightmost bit in each iteration and count the number of iterations.

Time Complexity: O(log(n))
Space Complexity: O(1)
*/

import java.util.Scanner;

class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n > 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.hammingWeight(n));
        scanner.close();
    }
}
