/*

Question - Make The String Great(Leetcode)
Link - https://leetcode.com/problems/make-the-string-great/description/

Take a stack.
Iterates through each character of the string,comparing each with the top of the stack. 
If the current character and the top of the stack differ only in their case (uppercase vs lowercase), both are removed.
Otherwise, the current character is added to the stack.
And at last  we will copy stack element into string ans until stack become empty
then at last ans will be in reverse order so we will reverse are ans string
and finally we will return our ans string

*/

import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            } else if (Math.abs(st.peek() - s.charAt(i)) == 32) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
