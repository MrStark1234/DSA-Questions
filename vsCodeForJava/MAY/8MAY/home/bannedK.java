// Atcoder - D - Banned K
//https://atcoder.jp/contests/abc159/tasks/abc159_d

import java.util.Scanner;

public class bannedK {
    public static long C2(long n) {
        if (n < 2)
            return 0;
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] freq = new int[200001];
        long[] a = new long[n];
        long ans = 0;

        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextLong();
            freq[(int) a[i]]++;
        }

        for (int num = 1; num <= 200000; ++num)
            ans += C2(freq[num]);

        for (int i = 0; i < n; ++i) {
            // Leaving the ith index out.
            System.out.println(ans - C2(freq[(int) a[i]]) + C2(freq[(int) a[i]] - 1));
            scanner.close();
        }
    }
}
