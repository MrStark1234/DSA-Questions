
// Link: https://leetcode.com/problems/running-sum-of-1d-array/
// Time: O(N)

import java.util.ArrayList;

class PrefixSum {
    public static ArrayList<Integer> runningSum(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>(nums.length);

        int sum = 0;
        for (int num : nums) {
            sum += num;
            ans.add(sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        ArrayList<Integer> result = runningSum(nums);
        System.out.println(result);
    }
}
