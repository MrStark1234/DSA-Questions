/*
Question - Zero Sum Subarrays (GFG)
Link - https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1

Approach -
    If a subarray [l,r] has a sum of 0, then prefixSum[l-1] should be equal to prefixSum[r].
    Now, for each r, we can calculate the number of l indices with the same sum, and 
    we can keep track of the count of l indices using a map while looping through.
*/

import java.util.HashMap;

class Solution {
    // Function to count subarrays with a sum equal to 0.
    public static long findSubarray(long[] arr, int n) {
        long ans = 0;
        HashMap<Long, Integer> mp = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0)
                ans++;
            ans += mp.getOrDefault(sum, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}