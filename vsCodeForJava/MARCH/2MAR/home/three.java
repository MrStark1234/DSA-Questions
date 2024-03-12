/*
Q3 - Number of occurrence
Question Link - https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

Logic - 
If f_idx denoes index of first occurence of target,
and l_idx denotes index of last occurence of target,
then the total occurences are equal to l_idx-f_idx+1

We already know how to find f_idx and l_idx - two binary searches

Time Complexity - O(2*log(n))
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(obj.count(arr, n, x));
        }
    }
}

class Solution {
    public int count(int[] arr, int n, int x) {
        int[] ans = { -1, -1 };

        // First search to find first occurrence of x
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                if (arr[mid] == x)
                    ans[0] = mid;
                hi = mid - 1;
            }
        }

        // Second search to find last occurrence of x
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > x) {
                hi = mid - 1;
            } else {
                if (arr[mid] == x)
                    ans[1] = mid;
                lo = mid + 1;
            }
        }

        if (ans[0] == -1)
            return 0;
        return ans[1] - ans[0] + 1;
    }
}
