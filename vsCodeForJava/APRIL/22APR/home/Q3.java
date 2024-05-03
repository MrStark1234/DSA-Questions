/*
Q3 - Coin Change II
Question Link - https://leetcode.com/problems/coin-change-ii/description/
Logic - 
DP State:
dp[i][j] = number of combinations to make an amount j if only first i coins are considered

Base Cases: 
dp[i][0] = 1 -> There is ony way to make an amount of zero (take no coins)
dp[0][j] = {
	0; if j>0 -> No coins remaining and non zero amount remaining
	1; if j=0 -> discussed above
}

Transitions:
At every step we can take a coin (if it is not greater than amount) or leave it. So we make two transitions:
dp[i][j] = x+y, where:
x = {
	dp[i][j-coins[i-1]]; if coins[i-1] <= j -> take the current coin, and still have the chance to take current coin with reduced amount
	0; otherwise
}

y = dp[i-i][j] -> Don't take the current coin, and when we decide not to take the curreent coin, we never return to it (i-1).

Final Answer: dp[coins.size()][amount]

Time Complexity: O(coins.size()*amount) (2 transitions per state)
Space Complexity: O(coins.size()*amount)
*/

import java.util.*;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Base cases
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }
        }

        // Transitions
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = 0;
                // take current coin if possible
                if (coins[i - 1] <= j)
                    dp[i][j] += dp[i][j - coins[i - 1]];
                // don't take current coin
                dp[i][j] += dp[i - 1][j];
            }
        }

        return dp[n][amount];
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int amount = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.change(amount, coins));
        scanner.close();
    }
}
