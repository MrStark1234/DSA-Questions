/*
https://leetcode.com/problems/array-partition/ 

Let’s understand with example 
nums = [1,2,3,4] 
Here are 2 smaller numbers 1 and 2 & 2 larger numbers are 3 and 4.
If we pair like (1,3) (2,4) means if I put two smaller number in the 2 pair then
I will end up having 1+2=3.
BUT if we put two smaller numbers together then we will have a chance to pick a large number.
(1,2) (3,4) -- 1 + 3 = 4.
 This is the best way because no matter what we pair a larger number
with another number, the another number will be smaller and will always be picked
Means we can never pick the 1st maximum value to include in the sum but we can pick the
2nd Maximum value to sum by pairing the smallest values 
together. That's why we sort the array first and then pair 
the numbers such that second maximum always get included in 
the sum.
*/

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
