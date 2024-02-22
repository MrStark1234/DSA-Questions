/*
Sum of Digit is Pallindrome or not
Question Link-https://www.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not2751/1


  First we can calculate its sum of digits and then we  reverse  this number 
  and if number is equal to its reverse then it is palindrome otherwise not.
*/

// User function Template for Java
class Solution {
    int reverseNum;

    int sumOfDigits(int n) {
        if (n == 0)
            return 0;
        // suppose number is 178 the we do (178%10)+sumOfDigits(178/10)
        // =(8)+sumOfDigits(17);then again we sumOfDigits call for (17).
        return (n % 10) + sumOfDigits(n / 10);
    }

    void reverseNumber(int num) {
        if (num == 0)
            return;

        int lastDigit = num % 10;
        reverseNum = (reverseNum * 10) + lastDigit;
        reverseNumber(num / 10);
    }
    /*
     * Take an example input of 197:
     * 1. reverseNumber(197) calls reverseNumber(19) and reverseNum will be 7
     * 2. reverseNumber(19) calls reverseNumber(1) and reverseNum will be 79
     * 3. reverseNumber(1) calls reverseNumber(0) and reverseNum will be 791
     * 4. reverseNumber(0) hits the base case and returns.
     */

    int isDigitSumPalindrome(int N) {
        int sumdig = sumOfDigits(N);
        reverseNum = 0;
        reverseNumber(sumdig);
        if (sumdig == reverseNum)
            return 1;
        return 0;
    }
}