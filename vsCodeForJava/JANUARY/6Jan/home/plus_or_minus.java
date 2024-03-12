/*
Q3 - Plus or Minus
Problem Link: https://codeforces.com/problemset/problem/1807/A
*/

import java.util.Scanner;

class plus_or_minus {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (a + b == c) {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            sc.close();
        }
        ;
    }
}
