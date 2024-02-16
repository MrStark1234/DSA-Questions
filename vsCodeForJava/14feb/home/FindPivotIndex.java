// Find Pivot Index
// https://leetcode.com/problems/find-pivot-index/description/

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = nums[i];
            if (i > 0) {
                left[i] += left[i - 1];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            right[i] = nums[i];
            if (i < n - 1) {
                right[i] += right[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            int l, r;
            if (i == 0) {
                l = 0;
            } else {
                l = left[i - 1];
            }
            if (i == n - 1) {
                r = 0;
            } else {
                r = right[i + 1];
            }
            if (l == r) {
                return i;
            }
        }
        return -1;
    }
}
