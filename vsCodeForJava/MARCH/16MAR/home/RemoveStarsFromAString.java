/*

Question - Removing Stars From a String
Link - https://leetcode.com/problems/removing-stars-from-a-string/description/

Use a stack s.
For each character c in string s,
if c == '*', pop the last element from the stack,for deletion.
if c != '*', push the element to the stack.

And at last  we will copy stack element into string ans until stack become empty
then at last ans will be in reverse order so we will reverse are ans string
and finally we will return our ans string
*/

import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!st.isEmpty()) {
                    st.pop();
                }
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
