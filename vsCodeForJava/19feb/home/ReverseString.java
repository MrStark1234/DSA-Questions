/*
Reverse String
Question Link - https://leetcode.com/problems/reverse-string/

Take two pointer start and end .
Swap start with end until start is smaller than end.
Now again call same function for start+1 and end-1.

*/

class Solution {
    public void helper(int start, int end, char[] s) {
        if (start > end)
            return;
        char temp = s[end];
        s[end] = s[start];
        s[start] = temp;
        helper(start + 1, end - 1, s);
    }

    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }
}
