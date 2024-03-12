// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/

// We need to make prefix_sum + suffix_sum = x. But instead of this, finding a subarray whose sum is sum(nums) - x will do the job. Now we only need to maximize the length of this subarray to minimize the length of prefix + suffix, which can be done greedily. By doing this, we can get the minimum length, i.e., the minimum number of operations to reduce x to exactly 0 (if possible).
// Let us take a sliding window whose ends are defined by start_idx and end_idx.
// If the sum of this sliding window (subarray) exceeds the target, keep reducing the window size (by increasing start_idx) until its sum becomes <= target.
// If the sum becomes equal to the target, compare the length, and store if it exceeds the previous length.
// Return -1 if the sum of the sliding window never becomes equal to target.

class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0, n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        int target = sum - x;
        int currSum = 0, maxLen = 0;
        int startIdx = 0;
        boolean found = false;

        for (int endIdx = 0; endIdx < n; endIdx++) {
            currSum += nums[endIdx];
            while (startIdx <= endIdx && currSum > target) {
                currSum -= nums[startIdx];
                startIdx += 1;
            }
            if (currSum == target) {
                found = true;
                maxLen = Math.max(maxLen, endIdx - startIdx + 1);
            }
        }
        return found ? n - maxLen : -1;
    }
}
