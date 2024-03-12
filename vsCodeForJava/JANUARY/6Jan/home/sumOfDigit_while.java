/*
Q1 - Sum of Digits
Problem link: https://www.geeksforgeeks.org/problems/sum-of-digits1742/1
*/

import java.util.Scanner;

class sumOfDigit_while {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.sumOfDigits(n));
        sc.close();
    }
}

class Solution {
    int sumOfDigits(int N) {
        int ans = 0;

        while (N > 0) {
            /*
             * At each step extract the last digit of N (N%10),
             * and it to ans,
             * and remove the extracted digit from N (N/10).
             */
            ans += N % 10;
            N /= 10;
        }

        return ans;
    }
}