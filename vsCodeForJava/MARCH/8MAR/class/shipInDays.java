import java.util.*;

// Link : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// Time : O(NLogN)

class Solution {
    int maxValue(int w[]) {
        int ans = 0;
        for (int num : w)
            ans = Math.max(ans, num);
        return ans;
    }

    int sumOfValues(int w[]) {
        int sum = 0;
        for (int num : w)
            sum += num;
        return sum;
    }

    int minDaysReq(int[] w, int cap) {
        int curDay = 1, curLoad = 0;

        for (int item : w) {
            if (curLoad + item <= cap)
                curLoad += item;
            else {
                curDay += 1;
                curLoad = item;
            }
        }

        return curDay;
    }

    public int shipWithinDays(int[] w, int days) {
        int beg = maxValue(w), end = sumOfValues(w), minCap = -1;
        while (beg <= end) {
            int midCap = (beg + end) / 2;
            if (minDaysReq(w, midCap) <= days) {
                minCap = midCap;
                end = midCap - 1;
            } else {
                beg = midCap + 1;
            }
        }
        return minCap;
    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int days = sc.nextInt();

            int w[] = new int[n];
            for (int i = 0; i < n; ++i)
                w[i] = sc.nextInt();

            Solution sol = new Solution();
            System.out.println(sol.shipWithinDays(w, days));
        }
    }
}
