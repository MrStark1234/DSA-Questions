import java.util.*;

class Main {
    public static boolean isValid(String s) {
        int open = 0;
        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == '(') {
                open += 1;
            } else if (open == 0) {
                return false;
            } else {
                open -= 1;
            }
        return open == 0;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.next();
            System.out.println(isValid(s));
        }
    }
}