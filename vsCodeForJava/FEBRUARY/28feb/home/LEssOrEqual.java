//https://codeforces.com/contest/977/problem/C

import java.util.*;

public class LEssOrEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Vector<Integer> a = new Vector<Integer>(n);
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        scanner.close(); // Close the scanner after reading input
        a.sort(null); // Sort the vector

        if (k == 0) {
            System.out.print(a.get(0) == 1 ? -1 : 1);
            return;
        }
        if (k == n) {
            System.out.print(a.get(n - 1));
            return;
        } else {
            if (a.get(k) == a.get(k - 1)) {
                System.out.print(-1);
                return;
            } else {
                System.out.print(a.get(k - 1));
                return;
            }
        }
    }
}
