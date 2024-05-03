/*
Q1 - Divisor Game
Problem Link - https://leetcode.com/problems/divisor-game/description/
Logic - 
DP State:
dp[i] = {
	true; if player with current move can win the game with current number as i
	false; if player with current move cannot win the game with current number as i
}

Transitions:
dp[i] = {
	true; if there exists j such that i%j==0, and j<i, and dp[i-j] = false;
	false; otherwise
} => sqrt(i) transitions per i

Final Answer: dp[n]

Time Complexity: less than O(n*sqrt(n))
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        for (int i = 2; i <= n; i++) {
            dp[i] = false;
            // loop to find factors of i
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    int f1 = j;
                    int f2 = i / j;
                    if (f1 < i && !dp[i - f1])
                        dp[i] = true;
                    if (f2 < i && !dp[i - f2])
                        dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution obj = new Solution();
        if (obj.divisorGame(n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        scanner.close();
    }
}
