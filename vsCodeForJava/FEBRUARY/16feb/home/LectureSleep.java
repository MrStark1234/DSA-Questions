/*
Q5 - Lecture Sleep
Question Link - https://codeforces.com/problemset/problem/961/B
Time Complexity - O(n+n) ~ O(n)
Space Complexity - O(n+n) ~ O(n)
*/

import java.util.Scanner;

public final class LectureSleep {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                t[i] = sc.nextInt();
            }
            int[] pre = new int[n + 1];
            int[] pre_weighted = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + a[i];
                pre_weighted[i + 1] = pre_weighted[i] + t[i] * a[i];
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int st = i;
                int en = i + k - 1;
                if (en >= n)
                    break;

                // if we use secret technique at index i,
                // mishka will stay awake from [st, en] no matter the value of t
                int curr = pre_weighted[st] + (pre[en + 1] - pre[st]) + (pre_weighted[n] - pre_weighted[en + 1]);
                ans = Math.max(ans, curr);
            }
            System.out.println(ans);
        }
    }
}
