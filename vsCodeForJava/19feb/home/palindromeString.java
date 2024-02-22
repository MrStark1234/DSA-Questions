/*
Palindrome String
Question Link - https://www.geeksforgeeks.org/problems/palindrome-string0817/1

Take two pointer start and end .
Check character at start and end are equal or not .
If they are equal then call for start+1 and end-1.
If they are not equal then return false.
If start becomes greater than end then return true.


This solution won't work for java at gfg due to it's large stack call.
*/

//User function Template for Java

class Solution {
    boolean isPalindromeHelp(String S, int st, int e) {
        if (st > e) {
            return true;
        }
        if (S.charAt(st) != S.charAt(e)) {
            return false;
        }
        return isPalindromeHelp(S, st + 1, e - 1);
    }

    int isPalindrome(String S) {
        int n = S.length();
        int st = 0;
        int e = n - 1;
        return isPalindromeHelp(S, st, e) ? 1 : 0;
    }
};