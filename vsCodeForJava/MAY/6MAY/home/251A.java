/*
As array is already sorted, we just have to find the 
find the first element >=a[i]+d.

sum += 1LL * (x - i - 2) * (x - i - 1) / 2;
This part calculates the number of pairs that can be
formed within the range [i+2, x-1]
*/

import java.util.Scanner;

class Solution {
    public void solve() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long ans = 0;

        int r = 0;
        for (int l = 0; l < n; l++) {
            r = Math.max(r, l);
            while (r + 1 < n && a[r + 1] - a[l] <= d)
                r++;
            if (r - l + 1 <= 2)
                continue;
            long cur = r - l;
            ans = ans + (long) cur * (long) (cur - 1) / 2;
        }

        System.out.println(ans);
        sc.close();
    }
}
