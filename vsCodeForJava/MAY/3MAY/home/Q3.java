/*
Q3 - Substring XOR Queries
Question Link - https://leetcode.com/problems/substring-xor-queries/description/

Logic:
val^left[i] = right[i]. This can be rearranged as val = left[i]^right[i].
So we need to find the minimum substring whose decimal representation is equal to
left[i]^right[i].

If we go on to string matching in each query, it will result in 10^5 * 10^4 * 30 operations which will result in TLE.

For optimization, we precompute the results for each target before iterating on queries.
An important observation is we only need to iterate over substrings of size at most 31.

Time Complexity: 
1. Building the Map (m):
In the worst case, for each character in the string s, there's an inner loop iterating over a maximum of 32 characters (from i to min(n, i+32)).
Thus, the time complexity for building the map is O(n * 32), where n is the length of the input string s.

2. Processing Queries:
For each query, the code checks if the result is present in the map (m), which takes O(log m) time complexity, where m is the size of the map. In this case, m could potentially have up to 2^32 keys.
Hence, the time complexity for processing the queries would be O(q * log(2^32)), where q is the number of queries.
Overall, the time complexity of the provided code can be expressed as:
O(n * 32 + q * log(2^32))

However, since 32 is a constant and log(2^32) is also a constant, the time complexity can be simplified to:
O(n + q)

Space Complexity: O(2^32 + q)
*/

import java.util.*;

class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        List<int[]> ans = new ArrayList<>();
        int n = s.length();

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (!map.containsKey(0)) {
                    map.put(0, new int[] { i, i });
                }
                continue;
            }
            int curr = 0;
            for (int j = i; j < Math.min(n, i + 32); j++) {
                curr = (curr << 1) + (s.charAt(j) - '0');
                if (!map.containsKey(curr)) {
                    map.put(curr, new int[] { i, j });
                }
            }
        }

        for (int[] query : queries) {
            int t = query[0] ^ query[1];
            if (!map.containsKey(t)) {
                ans.add(new int[] { -1, -1 });
            } else {
                ans.add(map.get(t));
            }
        }

        return ans.toArray(new int[0][]);
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        int[][] queries = new int[n][2];
        for (int i = 0; i < n; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }
        Solution obj = new Solution();
        int[][] ans = obj.substringXorQueries(s, queries);
        for (int[] a : ans) {
            System.out.println(a[0] + " " + a[1]);
        }
        scanner.close();
    }
}
