
/*
 * 
 * Question- Longest Alternating Subarray (Leetcode)
 * Link- https://leetcode.com/problems/longest-alternating-subarray/description/
 * 
 * 
 * 
 * Approach- For brute force run two loop and then check.
 * 
 * Optimal approach->
 * let suppose we got a subarray a1,a2,a3,a4,a5
 * for this to become alternating subarray a2-a1=1 ,a3-a2=-1,a4-a3=1,a5-a4=-1
 * we can see that we get alternating +1 and -1,
 * 
 * So we take 2 variable ans which store answer and curr which store how many
 * alternating
 * +1 and -1 comes consecutively
 * If curr is odd it means we need -1 and if it is even we need +1...so adjust
 * curr according to this.
 * 
 * 
 */

class LowestAlternatingSubarray {
    public int alternatingSubarray(int[] nums) {
        int ans = 0, curr = 0, n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                if (curr % 2 == 0)
                    curr++;
                else
                    curr = 1;
            } else if (nums[i] - nums[i - 1] == -1) {
                if (curr % 2 == 1)
                    curr++;
                else
                    curr = 0;
            } else {
                curr = 0;
            }
            ans = Math.max(ans, curr + 1);
        }

        if (ans == 1)
            return -1;
        return ans;
    }
}
