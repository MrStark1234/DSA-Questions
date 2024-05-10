import java.util.*;

public final class countArrays {

    static final long mod = 998244353;

    static long powMod(long a, long n) { // modulo inverse
        if (n == 0)
            return 1;
        long pt = powMod(a, n / 2);
        pt *= pt;
        pt %= mod;
        if ((n & 1) > 0) {
            pt *= a;
            pt %= mod;
        }
        return pt;
    }

    static long modInv(long a) {
        return powMod(a, mod - 2);
    }

    static long fact(long n) {
        long ans = 1l;
        for (long i = 1l; i <= n; ++i)
            ans = (ans * i) % mod;
        return ans;
    }

    static long C(long n, long r) {
        if (r > n)
            return 0;

        long num = fact(n);
        long den = (fact(r) * fact(n - r)) % mod;

        return (num * modInv(den)) % mod;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long n = sc.nextLong();
            long m = sc.nextLong();

            if (n == 2) {
                System.out.println(0);
                return;

            }

            // mCn-1 * (n-2) * 2^(n-3)
            long ans = C(m, n - 1);
            ans = (ans * (n - 2)) % mod;
            ans = (ans * powMod(2, n - 3)) % mod;

            System.out.println(ans);
        }

    }
}
