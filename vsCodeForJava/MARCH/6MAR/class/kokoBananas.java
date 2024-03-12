import java.util.*;

// Link : https://leetcode.com/problems/koko-eating-bananas/
// Time : O(N*Log(1e9))

class Solution {
    long hoursRequired(int[] arr, int k) {
        // 'long' is important, because otherwise
        // 'hoursReq' can overflow
        long hoursReq = 0;
        for (int num : arr) {
            hoursReq += Math.ceil(num / (double) k);
        }
        return hoursReq;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = (int) 1e9, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (hoursRequired(piles, mid) <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();

        int piles[] = new int[n];
        for (int i = 0; i < n; ++i)
            piles[i] = sc.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.minEatingSpeed(piles, h));
        sc.close();
    }
}
