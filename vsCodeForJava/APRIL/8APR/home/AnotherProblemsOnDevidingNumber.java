
/*
https://codeforces.com/contest/1538/problem/D
we calculated the sum of all powers of prime numbers.
and checked it with whether k is more than the sum of 
prime powers of a and b. 
If yes, ans is false, else true.
Alo checked for base cases and corner cases like, 
for a==b, and k==1, our output should be false.
*/
import java.util.*;

public class AnotherProblemsOnDevidingNumber {
    static StringBuilder sb;
    static long fact[];
    static int mod = (int) (1e9 + 7);

    static void solve() {
        int a = i();
        int b = i();
        int k = i();
        int af = factor(a);
        int bf = factor(b);
        if (k == 1 && a != b && (a % b == 0 || b % a == 0)) {
            System.out.println("Yes");
            return;
        }
        if (k != 1 && k <= af + bf) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");

    }

    public static int factor(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans++;
                n = n / i;
            }
        }
        if (n != 1)
            ans++;
        return ans;
    }

    public static void main(String[] args) {
        sb = new StringBuilder();
        int test = i();
        while (test-- > 0) {
            solve();
        }
        System.out.println(sb);

    }

    static int i() {
        return sc.nextInt();
    }

    static Scanner sc = new Scanner(System.in);
}
