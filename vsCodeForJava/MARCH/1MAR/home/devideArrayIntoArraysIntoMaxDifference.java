
// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/

// Sort the array
// Then from the begining, check if the three consecutive numbers have a diff
// less then k or not. TO do this we just need to check nums[i] - nums[i-2] <= k
// or not.
// If diff at any point > k then return empty array. Otherwise keep taking the
// triplet in the answer array.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> ansList = new ArrayList<>();

        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return new int[0][]; // Return an empty array if the condition is not met
            }
            ansList.add(new int[] { nums[i - 2], nums[i - 1], nums[i] });
        }

        int[][] ans = new int[ansList.size()][3];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}