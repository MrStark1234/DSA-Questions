import java.util.*;

// Link : https://codeforces.com/contest/312/problem/B

public final class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        double Wa = a / (double) b, Wb = c / (double) d;
        double La = 1.0 - Wa, Lb = 1.0 - Wb;

        double ans = Wa / (1.0 - La * Lb);

        System.out.println(ans);
        sc.close();
    }
}