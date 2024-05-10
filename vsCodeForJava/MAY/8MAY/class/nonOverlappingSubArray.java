import java.util.*;

// 1 <= n <= 10^4

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        long nC2 = n * (n - 1) / 2;
        long nC3 = n * (n - 1) * (n - 2) / 6;
        long nC4 = n * (n - 1) * (n - 2) * (n - 3) / 24;

        long ans = nC2 + 2 * nC3 + nC4;
        System.out.println(ans);
        sc.close();
    }
}
