/*
Q2 - Add Digits
Problem Link: https://leetcode.com/problems/add-digits/
*/

import java.util.Scanner;

class addDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.addDigits(n));
        sc.close();
    }
}

class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            /*
             * Find current digit sum at each step until
             * digit sum reaches a value <= 9.
             */
            int currSum = 0;
            while (num > 0) {
                currSum += num % 10;
                num /= 10;
            }
            num = currSum;
        }
        return num;
    }
}
