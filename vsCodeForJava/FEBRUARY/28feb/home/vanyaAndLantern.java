//https://codeforces.com/contest/492/problem/B

import java.util.*;

public class vanyaAndLantern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        Vector<Integer> a = new Vector<>(n);

        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        scanner.close(); // Close the scanner after reading input

        a.sort(null); // Sort the vector

        int ans = 2 * Math.max(a.get(0), l - a.get(n - 1));
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, a.get(i + 1) - a.get(i));
        }

        double res = ans / 2.0;
        System.out.println(res);
    }
}
