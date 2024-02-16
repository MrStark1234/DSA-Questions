
// Maximum prefix sum for a given range
// https://www.geeksforgeeks.org/problems/maximum-prefix-sum-for-a-given-range0227/1

class Solution {
    long[] maxPrefixes(long a[], long L[], long R[], long N, long Q) {
        long[] ans = new long[(int) Q];

        for (int i = 0; i < Q; i++) {
            long sum = a[(int) L[i]];
            long max_val = sum;

            for (int j = (int) (L[i] + 1); j <= R[i]; j++) {
                sum += a[j];
                max_val = Math.max(sum, max_val);
            }

            ans[i] = max_val;
        }

        return ans;

    }
}