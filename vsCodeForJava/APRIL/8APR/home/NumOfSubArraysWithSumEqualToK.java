/*
/*
https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/description/
Simply we can check all the subarrays and 
those having lcm=k we will increment the counter. 
Since n is less so n*n will not give tle .
Also lcm(a,b)=a*b/(gcd(a,b))
*/

class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int curGCD = nums[i];
            if (curGCD == k)
                ans++;
            for (int j = i + 1; j < nums.length; j++) {
                curGCD = lcm(nums[j], curGCD);
                if (curGCD == k)
                    ans++;
                if (nums[j] > k)
                    break;
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}