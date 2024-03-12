
//https://codeforces.com/problemset/problem/112/A
import java.util.Scanner;

public class petyaSrings {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            int result = s1.compareToIgnoreCase(s2);

            if (result < 0) {
                System.out.println("-1");
            } else if (result > 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

        }
    }
}
