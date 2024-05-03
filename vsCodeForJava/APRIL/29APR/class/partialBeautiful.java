import java.util.*;
import java.io.*;

// Link : https://www.codechef.com/problems/BEAUTPAR

public final class partialBeautiful {

    static int lowerBound(long dp[], long val) {
        int beg = 0, end = dp.length - 1, ans = dp.length;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (dp[mid] >= val) {
                ans = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return ans;
    }

    static int getLISlen(ArrayList<Long> val) {
        if (val.isEmpty()) {
            return 0;
        }

        long dp[] = new long[val.size() + 1];

        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = Long.MIN_VALUE;
        for (int i = 0; i < val.size(); ++i) { // keep updating dp
            int id = lowerBound(dp, val.get(i));
            if (id < dp.length) {
                dp[id] = val.get(i);
            }
        }

        int len = 1;
        while (len < val.size() && dp[len + 1] < Long.MAX_VALUE)
            len += 1;

        return len;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        while (t-- > 0) {
            String line[] = r.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            int a[] = new int[n];
            long pre[] = new long[n];
            String line2[] = r.readLine().split(" ");

            for (int i = 0; i < n; ++i) {
                a[i] = Integer.parseInt(line2[i]);
                pre[i] = i == 0 ? a[i] : pre[i - 1] + a[i];
            }

            if (k == 1) {
                if (pre[n - 1] > 0) {
                    w.print("YES\n");
                    w.print(n);
                } else
                    w.print("NO");
                w.print("\n");
                continue;
            }

            // Add the valid pre values and their corresponding
            // indices to 2 new different arrays
            ArrayList<Long> val = new ArrayList<>();

            for (int i = 0; i < n - 1; ++i) {
                if (pre[i] > 0 && pre[i] < pre[n - 1]) {
                    val.add(pre[i]);
                }
            }

            // Find the LIS out of this val array.
            int cuts = getLISlen(val);

            if (cuts < k - 1) {
                w.print("NO");
                w.print("\n");
            } else {
                w.print("YES");
                w.print("\n");
            }

        }

        r.close();
        w.close();
    }
}