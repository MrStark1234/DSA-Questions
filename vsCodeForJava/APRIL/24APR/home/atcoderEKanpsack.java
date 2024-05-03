//https://atcoder.jp/contests/dp/tasks/dp_e
// Atcoder - E -Knapsack 2 

// if you noticed that the traditional approach to solving knapsack problems, 
// which focuses on maximizing value within a given weight constraint, 
// won't work efficiently in this problem because it is impossible to make matrix of w*n=1e9*100
// so instead of considering each weight and finding its maximum value, 
// we will consider each value and find its minimum weight
// dp[i] will store the minimum weight for value i

import java.util.*;

public class atcoderEKanpsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int W = scanner.nextInt();

        int[] values = new int[N];
        int[] weights = new int[N];
        int totalValue = 0;

        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
            totalValue += values[i];
        }

        long[] DP = new long[totalValue + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = totalValue; j >= values[i]; j--) {
                DP[j] = Math.min(DP[j], DP[j - values[i]] + weights[i]);
            }
        }

        int answer = 0;
        for (int i = 0; i <= totalValue; i++) {
            if (DP[i] <= W) {
                answer = i;
            }
        }

        System.out.println(answer);
        scanner.close();
    }
}
