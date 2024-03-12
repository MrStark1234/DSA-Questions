
// Link : https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
// Time : O(Log(cuberoot(applesNeeded)))

class Solution {
    public long minimumPerimeter(long neededApples) {
        int beg = 1, end = (int) 1e5;
        long minL = -1;

        while (beg <= end) {
            long L = (beg + end) / 2;
            long curApples = 2 * L * (L + 1) * (2 * L + 1);

            if (curApples >= neededApples) {
                minL = L;
                end = (int) L - 1;
            } else
                beg = (int) L + 1;
        }

        return 8 * minL;
    }
}

// 1. No. of apples on the boundary s.t. corner coordinates are (-L, -L) and (L,
// L)?
// per_quadrant =
// 4*(per_quadrant) + 4*L

// (1, L), (2, L), (3, L), .... (L-1, L)
// (L, 1), (L, 2), (L, 3), .... (L, L - 1)
// (L, L)

// Per Quadrant = 3*L*(L-1) + 2*L
// Total = 12*L*(L-1) + 8*L + 4*L
// Total on boundary = 12*L*L

// There, total apples = 2*L*(L+1)*(2L+1)

// class Main {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int h = sc.nextInt();

// int piles[] = new int[n];
// for (int i = 0; i < n; ++i)
// piles[i] = sc.nextInt();

// Solution sol = new Solution();
// System.out.println(sol.minEatingSpeed(piles, h));
// }
// }