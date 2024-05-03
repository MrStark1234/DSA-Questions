// Leetcode - 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
// https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/description/

import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int[] dp = new int[arr.length]; // dp[i] := length of smallest subarray in range arr[0]...arr[i] with sum =
                                        // target
        Arrays.fill(dp, Integer.MAX_VALUE);

        int res = Integer.MAX_VALUE;

        // sliding window
        int sum = 0; // sum of current window
        int l = 0;
        for (int r = 0; r < arr.length; r++) {

            // invite new element into RHS
            sum += arr[r];

            // contract until valid
            while (l <= r && sum > target) {
                sum -= arr[l];
                l++;
            }

            // if valid, process
            if (sum == target) {

                // current window arr[l]...a[r]
                int lenCurr = r - l + 1;

                // want best from prev iterations, dp[l-1]
                int prevBest = (l == 0) ? Integer.MAX_VALUE : dp[l - 1];

                // process res
                if (prevBest != Integer.MAX_VALUE) {
                    res = Math.min(res, lenCurr + prevBest);
                }

                // now process dp
                dp[r] = (r == 0) ? lenCurr : Math.min(lenCurr, dp[r - 1]);
            } else {
                // else not valid, inherit dp[prev iteration]
                dp[r] = (r == 0) ? Integer.MAX_VALUE : dp[r - 1];
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}