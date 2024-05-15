// https://codeforces.com/contest/1288/problem/C

import java.util.*;

public class twoArrays {
    static final int mod = 1000000007;
    static final int N = 100010;

    static long binpow(long n, long x, long m) {
        if (x == 0)
            return 1;
        long ans = binpow(n, x / 2, m) % m;

        if ((x & 1) == 1) {
            return (((ans % m) * (ans % m) % m) * (n % m)) % m;
        } else {
            return (ans % m * ans % m) % m;
        }
    }

    static long inv(long a, long b) {
        return binpow(a, b - 2, b);
    }

    static void solve() {
        long[] fact = new long[N];
        fact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = (fact[i - 1] % mod * i % mod) % mod;
        }
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        long deno = (fact[(int) (n - 1)] % mod * fact[(int) (2 * m)] % mod) % mod;
        long ans = (fact[(int) (2 * m + (n - 1))] % mod * inv(deno, mod) % mod) % mod;

        System.out.println(ans);
        scanner.close();
    }

    public static void main(String[] args) {
        solve();
    }
}
