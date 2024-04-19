// codeforces - A. Almost Prime
// https://codeforces.com/contest/26/problem/A

import java.util.Scanner;

public class AlmostPrime {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            int[] countPrimeDivisors = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                if (countPrimeDivisors[i] == 0) { // means it is prime number
                    for (int j = 2 * i; j <= n; j += i) {
                        countPrimeDivisors[j]++;
                    }
                }
            }
            int ans = 0;
            for (int i = 2; i <= n; i++) {
                if (countPrimeDivisors[i] == 2)
                    ans++;
            }
            System.out.println(ans);
        }
    }
}