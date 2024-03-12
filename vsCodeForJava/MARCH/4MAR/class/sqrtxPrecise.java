import java.util.*;

class Solution {
    public double mySqrt(int x, int p) {
        double beg = 0, end = x;
        double precision = Math.pow(10, -p);
        while (end - beg >= precision) {
            double mid = (beg + end) / 2.0;
            if (mid * mid <= x)
                beg = mid;
            else
                end = mid;
        }
        return beg;
    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int p = sc.nextInt();

            Solution sol = new Solution();
            double ans = sol.mySqrt(n, p);
            double finalAns = Math.round(ans * Math.pow(10, p)) / Math.pow(10, p);

            System.out.println(finalAns);
        }
    }
}