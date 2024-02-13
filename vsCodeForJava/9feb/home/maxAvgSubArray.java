/*
Q2 - Maximum Average Subarray I
Question Link: https://leetcode.com/problems/maximum-average-subarray-i/description/

Time Complexity: O(n)
Space Complexity O(1) - (Ignoring the space taken up by input array)
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Solution obj = new Solution();
            System.out.print(obj.findMaxAverage(arr, k));
        }
    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // Finding max average is equivalent to finding max sum
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        maxSum = Math.max(maxSum, currSum);
        for (int i = k; i < n; i++) {
            currSum += nums[i];
            currSum -= nums[i - k];
            maxSum = Math.max(maxSum, currSum);
        }

        double ans = (1.0) * maxSum / k;
        return ans;
    }
}