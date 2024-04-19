/*

https://leetcode.com/problems/longest-palindrome/ 

Firstly we will count letters of all types in an unordered map. 
Now, to make a palindrome, first and last letters must be same. 
So, we need two letters of same type to make a palindrome.
and do the pairing to make the string a palindrome. 
But we can also add a middle character to a palindrome(Eg - aba).
So, if there is even a single letter which does not make pair 
then we can add 1 to count to increase the length of the 
palindrome. 
*/

import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        int len = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        boolean unpaired = false;
        for (char x : s.toCharArray()) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        for (int count : mp.values()) {
            len += count;
            if (count % 2 == 1) {
                unpaired = true;
                len--;
            }
        }
        if (unpaired) {
            len++;
        }
        return len;
    }
}
