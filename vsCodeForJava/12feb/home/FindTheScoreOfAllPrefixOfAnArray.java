
/*
 * 
 * Question- Find the Score of All Prefixes of an Array (Leetcode)
 * Link-
 * https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/
 * description/
 * 
 * 
 * Approach->
 * 
 * Take a variable mx which gives us maximum value till i index and
 * then make score array then take sum
 */

class FindTheScoreOfAllPrefixOfAnArray {
    public long[] findPrefixScore(int[] nums) {
        long[] result = new long[nums.length];
        long mx = 0;
        for (int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, nums[i]);
            result[i] = (mx + nums[i]);
        }

        for (int i = 1; i < nums.length; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }
}
