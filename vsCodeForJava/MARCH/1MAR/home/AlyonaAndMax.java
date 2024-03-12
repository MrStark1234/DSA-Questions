// https://codeforces.com/problemset/problem/682/B

// sort the array. Let cur = 1. Then walk through the array.
// Then look at current number. If it is greater or equal to cur,
// then increase cur by 1. Answer is cur.

import java.util.Arrays;
import java.util.Scanner;

public class AlyonaAndMax {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            Arrays.sort(a);

            int cur = 1;
            for (int i = 0; i < n; i++) {
                if (a[i] >= cur) {
                    cur++;
                }
            }

            System.out.println(cur);
        }
    }
}