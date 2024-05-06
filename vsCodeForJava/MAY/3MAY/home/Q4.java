/*
Q4 - Bitwise ORs of Subarrays
Question Link - https://leetcode.com/problems/bitwise-ors-of-subarrays/description/

Logic:
Assume B[i][j] = A[i] | A[i+1] | ... | A[j].
Hash set cur stores all wise B[0][i], B[1][i], B[2][i], B[i][i].

When we handle the A[i+1], we want to update cur.
So we need to operate bitwise OR on all elements in cur.
Also, we need to add A[i+1] to cur.

In each turn, we add all elements in cur to res.

Time Complexity: O(30*N)
The reason is that, B[0][i] >= B[1][i] >= ... >= B[i][i].
B[0][i] covers all bits of B[1][i].
B[1][i] covers all bits of B[2][i].
....

There are at most 30 bits for a positive number 0 <= A[i] <= 10^9.
So there are at most 30 different values for B[0][i], B[1][i], B[2][i], ..., B[i][i].
Finally, cur.size() <= 30 and res.size() <= 30 * A.length().

In the worst case, A = {1,2,4,8,16,..., 2 ^ 29}.
And all B[i][j] are different and res.size() == 30 * A.length().
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        Set<Integer> cur2;

        for (int i : arr) {
            cur2 = new HashSet<>();
            cur2.add(i);
            for (int j : cur)
                cur2.add(i | j);
            cur = cur2;
            res.addAll(cur);
        }

        return res.size();
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.subarrayBitwiseORs(arr));
        scanner.close();
    }
}
