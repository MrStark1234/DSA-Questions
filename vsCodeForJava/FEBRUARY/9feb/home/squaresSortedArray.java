/*
Q4 - Squares of a Sorted Array
Question Link: https://leetcode.com/problems/squares-of-a-sorted-array/description/

Time Complexity: O(n)
Space Complexity O(n)
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Solution obj = new Solution();
            int[] ans = obj.sortedSquares(arr);
            for (int i = 0; i < n; i++)
                System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = n - 1;

        // fill ans array from back finding maximum value among squares of nums[i] &
        // nums[j]
        int ansPtr = n - 1;
        while (i <= j) {
            int x = nums[i] * nums[i];
            int y = nums[j] * nums[j];
            if (x > y) {
                ans[ansPtr--] = x;
                i++;
            } else {
                ans[ansPtr--] = y;
                j--;
            }
        }
        return ans;
    }
}