import java.util.*;

// Time : O(N)

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int d[] = new int[n];
            for (int i = 0; i < n; ++i)
                d[i] = sc.nextInt();

            int curId = 0;
            int minJumps = 0;
            while (curId < n) {
                int nextId = curId, curDist = 0;
                while (nextId + 1 <= n && curDist + d[nextId] <= k) {
                    curDist += d[nextId];
                    nextId += 1;
                }

                if (curId == nextId) {
                    System.out.println(-1);
                    return;
                }

                // System.out.println("CurId : " + curId + ", NextId: " + nextId);

                curId = nextId;
                minJumps += 1;
            }
            System.out.println(minJumps);
        }

    }
}
