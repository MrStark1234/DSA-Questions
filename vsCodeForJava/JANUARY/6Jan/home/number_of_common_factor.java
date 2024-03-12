/*
Q6 - Number of Common Factors
Problem Link: https://leetcode.com/problems/number-of-common-factors/
*/

import java.util.Scanner;

//Driver Code (Ignore)
class number_of_common_factor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.commonFactors(a, b));
        sc.close();
    }
}

// Solution Code
class Solution {
    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            /*
             * If i can divide both a and b, then i is a common factor
             */
            if (a % i == 0 && b % i == 0)
                ans++;
        }
        return ans;
    }
}
