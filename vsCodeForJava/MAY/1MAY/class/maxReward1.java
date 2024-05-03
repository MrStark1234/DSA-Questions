import java.util.*;

class Main {
    static int maxRewards(int rew[][], int n) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int bestReward = 0;
            for (int j = 0; j < n; ++j)
                bestReward = Math.max(bestReward, rew[i][j]);
            ans += bestReward;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rew[][] = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                rew[i][j] = sc.nextInt();
        System.out.println(maxRewards(rew, n));
        sc.close();
    }
}