// https://codeforces.com/problemset/problem/454/C

// The maximum number of layers in the n-dimensional super-cube,
// each with a distribution of a large cube minus a smaller cube, 
// is 2^n. This is because for each dimension, there are two sides 
// of the cube, the exterior and the interior, resulting in 2 possibilities
// for each dimension, thus yielding 2^n layers in total.

import java.util.Scanner;

public class littlePonyAndExpectedMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextDouble();
        double n = scanner.nextDouble();
        double ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += i * (Math.pow(i / m, n) - Math.pow((i - 1) / m, n));
        }
        System.out.printf("%.5f\n", ans);
        scanner.close();
    }
}
