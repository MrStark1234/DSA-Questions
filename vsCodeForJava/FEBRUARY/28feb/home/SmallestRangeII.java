//https://leetcode.com/problems/smallest-range-ii/description/

import java.util.Arrays;

public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[nums.length - 1] - nums[0];
        for (int i = 0; i < nums.length - 1; ++i) {
            int max = Math.max(nums[i] + k, nums[nums.length - 1] - k);
            int min = Math.min(nums[i + 1] - k, nums[0] + k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
