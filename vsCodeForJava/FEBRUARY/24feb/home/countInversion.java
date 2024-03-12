
/*
 * Q4 - Count Inversions
 * Question Link -
 * https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * 
 * Logic -
 * Straightforward merge sort logic as discussed in class
 * 
 * Time Complexity - O(n*log(n));
 * Space Complexity - O(n);
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long n = sc.nextLong();
            long[] arr = new long[(int) n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextLong();
            Solution obj = new Solution();
            System.out.println(obj.inversionCount(arr, n));
        }
    }
}

class Solution {
    static long mergeAndCount(long arr[], long left[], long right[]) {
        int i = 0, j = 0, k = 0;
        long ans = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                // when left[i] > right[j] it means right[i] is less than n1 - i elements in the
                // left part
                // so add n1 - i in ans to account for inversions due to right [i]
                ans += left.length - i; // add appropriate value to ans;
                arr[k++] = right[j++];
            }
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

        return ans;
    }

    long inversionCount(long arr[], long N) {
        if (N == 1)
            return 0;

        long left[] = Arrays.copyOfRange(arr, 0, (int) N / 2);
        long right[] = Arrays.copyOfRange(arr, (int) N / 2, (int) N);

        // Total inversion count will be sum of three values:
        // 1. Inversion count purely due to left part
        // 2. Inversion count purely due to right part
        // 3. Inversion count due to indices i and j such that i belongs to left part
        // and j belongs to right part
        return inversionCount(left, left.length) + inversionCount(right, right.length)
                + mergeAndCount(arr, left, right);
    }
}