/*

Question - Regular Bracket Sequence
Link - https://codeforces.com/contest/26/problem/B

Take a stack and a variable 'ans' to keep track of the number of brackets that need to be removed.
 Traverse the string from left to right: if an open bracket '(' is encountered, push it onto the stack. 
 Otherwise, if a close bracket ')' is encountered and the stack is empty,
  it means there is no corresponding open bracket for this close bracket,
   so remove this close bracket and increment 'ans'.

If the stack is not empty when encountering a close bracket,
 it means there is an open bracket available to pair with this close bracket. 
 Remove that open bracket from the stack.

Lastly, any remaining open brackets in the stack do not have a corresponding
 close bracket to pair with, so add all these brackets to 'ans'. 
 Finally, print all remaining characters in the string.

*/

import java.util.Scanner;
import java.util.Stack;

public class RegularBracketSequence {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.next();
            int n = s.length();
            int ans = 0;
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    st.push(s.charAt(i));
                } else {
                    if (st.isEmpty()) {
                        ans++;
                    } else {
                        st.pop();
                    }
                }
            }
            ans += st.size();
            System.out.println(n - ans);
        }
    }
}
