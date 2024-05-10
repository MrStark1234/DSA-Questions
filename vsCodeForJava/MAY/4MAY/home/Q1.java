class Solution {
    static int visited_all;

    public int total_cost(int[][] cost) {
        int n = cost.length;
        visited_all = (1 << n) - 1;
        int rows = (int) Math.pow(2, n);
        Integer dp[][] = new Integer[rows][n];
        return tsp(1, 0, dp, cost);
    }

    int tsp(int mask, int pos, Integer[][] dp, int[][] cost) {
        if (mask == visited_all)
            return cost[pos][0];
        if (dp[mask][pos] != null)
            return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < cost.length; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = cost[pos][city] + tsp((mask | (1 << city)), city, dp, cost);
                ans = Math.min(ans, newAns);
            }
        }
        return dp[mask][pos] = ans;
    }
}
