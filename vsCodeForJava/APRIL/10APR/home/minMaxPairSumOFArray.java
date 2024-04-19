/*
https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/


Picking the element greedily will help. For the largest element,
we need to have the smallest element of the array paired with 
it because if we take any other element for that, then the 
paired sum with the largest element will always increase. 
Similarly for second largest element, second smallest element 
will be taken and so on. Then we can find the maximum sum among
all the possible pairs. 

*/

import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int max_sum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            max_sum = Math.max(max_sum, nums[i] + nums[j]);
        }
        return max_sum;
    }
}
