import java.util.*;

class Main {
    static final int mod = 1000000007;

    static int[] extendedEuclid(int a, int b) {
        if (b == 0)
            return new int[] { 1, 0 };
        int[] partialSol = extendedEuclid(b, a % b);
        int xPartial = partialSol[0], yPartial = partialSol[1];
        return new int[] { yPartial, xPartial - (a / b) * yPartial };
    }

    static int modInverse(int a) {
        int x = extendedEuclid(a, mod)[0];
        x = (x % mod + mod) % mod;
        return x;
    }

    static int fact(int n) {
        long ans = 1;
        for (int i = 1; i <= n; ++i)
            ans = (ans * i) % mod;
        return (int) ans;
    }

    public static int countAnagramsWord(String s) {
        HashMap<Character, Integer> f = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            f.put(s.charAt(i), f.getOrDefault(s.charAt(i), 0) + 1);
        }

        long ans = fact(s.length());

        for (Character ch : f.keySet()) {
            int curFreq = f.get(ch);
            int factCurFreq = fact(curFreq);
            ans = (ans * modInverse(factCurFreq)) % mod;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            System.out.println(countAnagramsWord(s));
        }
    }
}
