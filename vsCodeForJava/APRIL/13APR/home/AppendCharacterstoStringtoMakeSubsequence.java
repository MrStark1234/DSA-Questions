/*
Q5 - Append Characters to String to Make Subsequence
Question Link - https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/

Logic - 
Since we can only add to the back of s, means we can only create some suffix of t
by appending to s.
So we need to find out how much prefix of t is already present in s as a subsequence.

Time Complexity - O(n+m)
Space Complexity - O(1) 
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        Solution obj = new Solution();
        System.out.println(obj.appendCharacters(s, t));
        scanner.close();
    }
}

class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return m - j;
    }
}
