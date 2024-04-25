// https://leetcode.com/problems/generate-parentheses/description/

// We have to find the number of possible combinations such that each combination we have balanced parentheses. 
//Initially we will have an empty string. We have to make a string of length 2n. There are two cases ➖
// Add ‘)’ bracket to current string
// It will only be possible when number of open brackets does not exceed n otherwise there will not be balanced closed parentheses equal to that. 
// So, number of open brackets does not exceed n.
// Add ‘(’ bracket
// It will only be possible when current number of open brackets is greater than number of closed 
// brackets otherwise string will not become balanced

// Then add the brackets for the corresponding gates and recursively form the further string for both the cases

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int n) {

        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }

        if (open < n)
            backtrack(list, str + "(", open + 1, close, n);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, n);
    }
}
