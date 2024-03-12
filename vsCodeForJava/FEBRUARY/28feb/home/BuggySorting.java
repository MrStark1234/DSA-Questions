//https://codeforces.com/problemset/problem/246/A [a different one, do give it a try]

import java.util.Scanner;

public class BuggySorting {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            if (n <= 2) {
                System.out.println(-1);
                return;

            }
            for (int i = 0; i < n; i++) {
                System.out.print((n - i) + " ");
            }
        }

    }
}
