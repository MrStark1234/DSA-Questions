// codeforces -B. Rectangles
// https://codeforces.com/problemset/problem/844/B

/*
every group of cells we're considering is always within a single row 
or column.
We should calculate numbers of white and black cells count_0 and count_1 
in every row and every column. For every count we will summarize 2^count - 1 
(the number of non-empty subsets of this color contained in one row/column).

In the end, we subtract n·m from the whole sum (this is a number of one-cell sets, which we count twice) 

*/
import java.util.Scanner;

public class Ractangales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int count_1 = 0, count_0 = 0;
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 1) {
                    count_1++;
                } else {
                    count_0++;
                }
            }
            ans += (1L << count_1) - 1; // (1L<<count_1) means 2^(count_1)
            ans += (1L << count_0) - 1;
        }

        for (int i = 1; i <= m; i++) {
            int count_1 = 0, count_0 = 0;
            for (int j = 1; j <= n; j++) {
                if (a[j][i] == 1) {
                    count_1++;
                } else {
                    count_0++;
                }
            }
            ans += (1L << count_1) - 1;
            ans += (1L << count_0) - 1;
        }
        ans -= (long) n * m; // because the number of one-cell sets we counted twice
        System.out.println(ans);
        scanner.close();
    }
}
