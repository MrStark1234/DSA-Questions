// Link : https://www.geeksforgeeks.org/problems/finding-the-numbers/1

class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        res -= (res & (res - 1));

        int a = 0, b = 0;

        for (int num : nums)
            if ((num & res) > 0)
                a ^= num;
            else
                b ^= num;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return new int[] { a, b };
    }
}
