/*

Question- Left and Right Sum Differences (Leetcode)
Link- https://leetcode.com/problems/left-and-right-sum-differences/description/



Approach-
Take prefix and suffix sum and then calculate there difference.

TC-> O(N)
SC->O(N)


*/



class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            right[i] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            left[i] = sum;
        }
      
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(left[i] - right[i]);
        }
        return result;
    }
}
