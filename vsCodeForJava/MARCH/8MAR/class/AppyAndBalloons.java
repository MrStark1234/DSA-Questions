import java.util.*;

// Link : https://www.codechef.com/problems/HMAPPY
// Time : O(N*Log(max(Ai*Bi)))

class Solution {
    public long minBalloonsReq(int a[], int b[], long maxCandies) {
        long ans = 0;
        for (int i = 0; i < a.length; ++i) {
            if (b[i] == 0)
                continue;
            ans += Math.max(0, a[i] - maxCandies / b[i]);
        }
        return ans;
    }

    public long getMinCandies(int[] a, int[] b, long balloonLimit) {
        long beg = 0, end = (long) 1e18, ans = -1;
        while (beg <= end) {
            long mid = (beg + end) / 2;
            if (minBalloonsReq(a, b, mid) <= balloonLimit) {
                ans = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long m = sc.nextLong();

            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; ++i)
                a[i] = sc.nextInt();

            for (int i = 0; i < n; ++i)
                b[i] = sc.nextInt();

            Solution sol = new Solution();
            System.out.println(sol.getMinCandies(a, b, m));
        }
    }
}