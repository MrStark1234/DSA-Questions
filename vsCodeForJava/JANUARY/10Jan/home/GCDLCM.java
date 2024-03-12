
//Problem Link:- https://codeforces.com/problemset/problem/1665/A
import java.util.Scanner;

public class GCDLCM {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                if(n<=2)
                System.out.println("False");
                else
                System.out.print(n - 3 + " " + 1 + " " + 1 + " " + 1);
                System.out.println();
            }
        }
    }
}
