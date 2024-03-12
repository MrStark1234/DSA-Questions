// https://codeforces.com/problemset/problem/489/A

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swapSort {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            List<Pair> answer = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            // All you need to do is
            // swap the current minimum with the i-th element each time.
            for (int i = 0; i < n; i++) {
                int j = i;
                for (int t = i; t < n; t++) {
                    if (a[j] > a[t]) {
                        j = t;
                    }
                }
                if (i != j) {
                    answer.add(new Pair(i, j));
                }
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            // This solution makes at most n-1 swap operation.
            System.out.println(answer.size());
            for (Pair pair : answer) {
                System.out.println(pair.first + " " + pair.second);
            }
        }
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
