import java.util.*;

// Link : https://codeforces.com/problemset/problem/1881/D

// Time : O(N*sqrt(Ai)) per test

public final class devideEqualize {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                HashMap<Integer, Integer> primeFreq = new HashMap<>();
                for (int i = 0; i < n; ++i) {
                    int ai = sc.nextInt();
                    for (int num = 2; num * num <= ai; ++num) {
                        while (ai % num == 0) {
                            primeFreq.put(num, primeFreq.getOrDefault(num, 0) + 1);
                            ai /= num;
                        }
                    }
                    if (ai > 1)
                        primeFreq.put(ai, primeFreq.getOrDefault(ai, 0) + 1);
                }

                // Powers of all the primes should
                // be a multiple of n
                String ans = "YES";
                for (int prime : primeFreq.keySet()) {
                    int freq = primeFreq.get(prime);
                    if (freq % n != 0) {
                        ans = "NO";
                        break;
                    }
                }

                System.out.println(ans);
            }
        }
    }
}