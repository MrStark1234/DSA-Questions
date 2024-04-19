// leetcode - 1390. Four Divisors
// https://leetcode.com/problems/four-divisors/description/

class Solution {
    public int sumFourDivisors(int[] nums) {
        // find max element
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }

        int[] countDivisors = new int[mx + 1];//// for storing divisors and their sum
        int[] sumDivisors = new int[mx + 1];

        for (int i = 1; i <= mx; i++) {
            for (int j = i; j <= mx; j += i) {
                countDivisors[j]++;
                sumDivisors[j] += i;
            }
        }

        int sum = 0;
        for (int num : nums) {
            if (countDivisors[num] == 4) {
                sum += sumDivisors[num];
            }
        }

        return sum;
    }
}