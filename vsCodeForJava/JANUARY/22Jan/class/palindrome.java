import java.util.Scanner;

class palindrome {
    public static void main(String[] args) {
        try (// you code goes here
                Scanner sc = new Scanner(System.in)) {
            String str = sc.next();

            int i = 0, j = str.length() - 1;

            String ans = "Yes";

            while (i <= j) {
                if (str.charAt(i) != str.charAt(j)) {
                    ans = "No";
                    break;
                }

                // after every iteration
                i++;
                j--;
            }
            System.out.println(ans);
        }
    }
}
