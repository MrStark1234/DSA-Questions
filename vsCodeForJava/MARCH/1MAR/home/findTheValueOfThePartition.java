// https://leetcode.com/problems/find-the-value-of-the-partition/description/

// Sort the array
// Now we can split the array in to part from the point where the two consicutive elemnts have min difference. So the lower side array have max value and the next element is the min of the next upper side array section.
// so keep iterating to get the min diff betteen two consicutive elements.

import java.util.Arrays;

class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.min(ans, Math.abs(nums[i] - nums[i + 1]));
        }

        return ans;
    }
}

// Example:Let's

// dry run
// the code
// with an
// example input
// array nums = [3, 1, 4, 6, 9]:

// After sorting, the
// array becomes nums=[1,3,4,6,9].
// Initialize ans
// to Integer.
// MAX_VALUE.Iterate through
// the array:
// At i = 0, Math.abs(nums[i]-nums[i+1])=Math.abs(1-3)=2.
// At i = 1, Math.abs(nums[i]-nums[i+1])=Math.abs(3-4)=1.
// At i = 2, Math.abs(nums[i]-nums[i+1])=Math.abs(4-6)=2.
// At i = 3, Math.abs(nums[i]-nums[i+1])=Math.abs(6-9)=3.
// Update ans
// to the
// minimum value found:ans=Math.min(Integer.MAX_VALUE,2,1,2,3)=1.
// Return ans = 1.