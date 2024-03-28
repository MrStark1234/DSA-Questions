/*
Question - Backspace String Compare(Leetcode)
Link - https://leetcode.com/problems/backspace-string-compare/description/
    
	We will traverse both the strings and
    if we encounter an character other than '#' then we will push it into the stack
    and if we encounter the character '#' then we need to perform backspacing and 
	for this we will simply pop an element from stack.
	And at last we Check both stack are same are not.

*/

import java.util.Stack;

class Solution {
    public boolean isSame(Stack<Character> st1, Stack<Character> st2) {
        if (st1.size() != st2.size()) // if the size is not same then it simply means after applying backspacing the
                                      // two strings are not same so return false
            return false;
        while (!st1.isEmpty() && !st2.isEmpty()) {
            if (st1.peek() != st2.peek())
                return false;
            st1.pop();
            st2.pop();
        }
        return true;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && !st1.isEmpty()) {
                st1.pop();
            } else if (s.charAt(i) != '#') {
                st1.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#' && !st2.isEmpty()) {
                st2.pop();
            } else if (t.charAt(i) != '#') {
                st2.push(t.charAt(i));
            }
        }
        return isSame(st1, st2);
    }
}
