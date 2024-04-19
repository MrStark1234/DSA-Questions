/*
Q4 - Gcd Queries
Question Link - https://www.codechef.com/JAN15/problems/GCDQ

Logic - 
Before processing the queries, we first create prefix gcd and suffix gcd arrays
to calculate gcd(arr[0]....arr[l-1]) and gcd(arr[r+1]....arr[n-1]) in constant time


Time Complexity - O(n+n+n+q*log(max(A[i])))
Space Complexity - O(n)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] preGcd = new int[n + 1];
            int[] sufGcd = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preGcd[i + 1] = gcd(preGcd[i], arr[i]);
            }
            for (int i = n - 1; i >= 0; i--) {
                sufGcd[i] = gcd(sufGcd[i + 1], arr[i]);
            }
            while (q-- > 0) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                System.out.println(gcd(preGcd[l - 1], sufGcd[r]));
            }
        }
        scanner.close();
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
