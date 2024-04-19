import java.util.*;

class Main {
    static final long mod = 1000000007;

    static long mul(long a, long b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    static long powUnderMod(long a, long n) {
        if (n == 0)
            return 1;
        long partialAns = powUnderMod(a, n / 2);

        partialAns = mul(partialAns, partialAns);

        if (n % 2 == 0)
            return partialAns;

        return mul(partialAns, a);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long a = sc.nextLong();
            long n = sc.nextLong();
            System.out.println(powUnderMod(a, n));
        }
    }
}