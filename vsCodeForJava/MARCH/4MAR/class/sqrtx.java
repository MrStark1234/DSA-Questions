import java.util.*;

class Solution {
    public int mySqrt(int x) {
        int beg = 0, end = x, ans = -1;
        while (beg <= end) {
            // 'long' because otherwise
            // mid*mid can overflow
            long mid = (beg + end) / 2;

            if (mid * mid <= x) {
                ans = (int) mid;
                beg = (int) mid + 1;
            } else
                end = (int) mid - 1;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            Solution sol = new Solution();
            System.out.println(sol.mySqrt(n));
        }
    }
}
