// Link : https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

import java.util.Stack;

class Solution {
    private int evaluate(int a, int b, String op) {
        if (op.equals("+"))
            return a + b;
        if (op.equals("-"))
            return a - b;
        if (op.equals("*"))
            return a * b;

        return a / b;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                s.push(evaluate(a, b, token));
            } else { // it's an operand
                s.push(Integer.parseInt(token));
            }
        }
        return s.peek();
    }
}

// [1, 3, 4]
// -

// 3 - 4