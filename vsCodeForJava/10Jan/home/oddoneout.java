
//problem link:- https://codeforces.com/contest/1915/problem/A
import java.util.Scanner;

public class oddoneout {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int x = sc.nextInt();
           
            for (int i = 1; i <= x; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (a != b && a != c) {
                    System.out.println(a);
                } else if (b != a && b != c) {
                    System.out.println(b);
                } else {
                    System.out.println(c);
                }
            }
            sc.close();
        }
    }
}
