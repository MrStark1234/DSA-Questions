//https://read.learnyard.com/traversals-5/

class Solution {
    public int maxConsecutiveOnce(int[] nums) {
        int final_ans = 0, cur_ones = 0;

        for (int num : nums) {
            if (num == 0)
                cur_ones = 0;
            else // the value of num will be 1
                cur_ones += 1;
            final_ans = Math.max(final_ans, cur_ones);
        }

        return final_ans;
    }
}