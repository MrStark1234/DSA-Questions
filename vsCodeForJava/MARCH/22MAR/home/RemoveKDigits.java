import java.util.*;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        // get all eligible elements in a stack
        Stack<Character> s = new Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !s.isEmpty() && s.peek() > c) {
                s.pop();
                k--;
            }
            s.push(c);
        }

        // if still no change in k then remove k elements
        if (k > 0) {
            while (k-- > 0) {
                s.pop();
            }
        }

        // remove leading 0s, if present
        Stack<Character> t = new Stack<>();
        while (!s.isEmpty()) {
            t.push(s.pop());
        }
        while (!t.isEmpty() && t.peek() == '0') {
            t.pop();
        }

        // return the answer
        StringBuilder result = new StringBuilder();
        while (!t.isEmpty()) {
            result.append(t.pop());
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        String num = "1432219";
        int k = 3;
        System.out.println(solution.removeKdigits(num, k)); // Output: "1219"
    }
}
