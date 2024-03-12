// https://www.spoj.com/problems/PRATA/

import java.util.*;

class Main {
    static long maxByCook(long rank, long time_allowed) {
        long beg = 0, end = time_allowed, ans = -1;

        while (beg <= end) // Binary Searching for max. number of paratas possible to be cooked within t
                           // seconds
        {
            long mid = (beg + end) / 2;

            long time_for_mid = (rank * (mid + 1) * mid) / 2; // 4 * (4e6) * (4e6) -> 6.4e13

            if (time_for_mid <= time_allowed) {
                ans = mid;
                beg = mid + 1;
            }

            else
                end = mid - 1;
        }

        return ans;
    }

    static long maxParatas(long t, long r[], long n) {
        long total_paratas = 0;

        for (int i = 0; i < n; ++i)
            total_paratas += maxByCook(r[i], t);

        return total_paratas;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long t = sc.nextLong();
            while (t-- > 0) {
                long p = sc.nextLong();
                int n = sc.nextInt();
                long r[] = new long[n];

                for (int i = 0; i < n; ++i)
                    r[i] = sc.nextLong();

                long beg = 0, end = (r[0] * p * (p + 1)) / 2, ans = -1;

                while (beg <= end) // binary search for minimum reqd time
                {
                    long mid = (beg + end) / 2;

                    if (maxParatas(mid, r, n) >= p) {
                        ans = mid;
                        end = mid - 1;
                    } else
                        beg = mid + 1;
                }

                System.out.println(ans);
            }
        }
    }
}