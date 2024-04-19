// Link : https://leetcode.com/problems/find-greatest-common-divisor-of-array/

class Solution {
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int findGCD(int[] nums) {
        int mx = 0, mn = 10000;
        for (int num : nums) {
            mx = Math.max(num, mx);
            mn = Math.min(num, mn);
        }
        return gcd(mn, mx);
    }
}
