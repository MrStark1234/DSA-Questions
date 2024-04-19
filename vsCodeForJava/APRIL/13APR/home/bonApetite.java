/*
Q4 - Bon Appetit
Question Link - https://www.codechef.com/problems/FGFS

Logic - 
This question is almost same to the previous question (Non-overlapping Intervals).
Just categorize the intervals based on their preferred compartment (p) values.

Time Complexity - O(t*n*log(n))
Space Complexity - O(n) 
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        // int k = scanner.nextInt();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int f = scanner.nextInt();
            int p = scanner.nextInt() - 1;
            if (!map.containsKey(p)) {
                map.put(p, new ArrayList<>());
            }
            map.get(p).add(new int[] { s, f });
        }
        int ans = 0;
        for (List<int[]> intervals : map.values()) {
            Collections.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
            int currEnd = -1;
            for (int[] interval : intervals) {
                if (interval[0] >= currEnd) {
                    ans++;
                    currEnd = interval[1];
                } else {
                    currEnd = Math.min(currEnd, interval[1]);
                }
            }
        }
        System.out.println(ans);
    }
}
