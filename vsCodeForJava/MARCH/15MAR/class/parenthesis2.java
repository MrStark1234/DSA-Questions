import java.util.*;

class Main {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '[')
                s.push(']');
            else if (ch == '{')
                s.push('}');
            else if (ch == '(')
                s.push(')');
            else if (s.empty() || s.peek() != ch)
                return false;
            else
                s.pop();
        }
        return s.empty();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.next();
            System.out.println(isValid(s));
        }
    }
}
