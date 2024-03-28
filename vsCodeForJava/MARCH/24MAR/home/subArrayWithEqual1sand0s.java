/*
Question - Subarrays with equal 1s and 0s (GFG)
Link - https://www.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1

Approach -
    This question is the same as the zero sum subarrays problem.
    If we consider 0 as -1, then a subarray with equal numbers of 1s and 0s will have a sum of 0.
    Hence, this question can be converted to the zero sum subarrays problem.
*/

import java.util.HashMap;

class Solution {
    // Function to count subarrays with equal numbers of 0s and 1s.
    public long countSubarrWithEqualZeroAndOne(int[] arr, int n) {
        long ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                sum -= 1;
            else
                sum += 1;
            if (sum == 0)
                ans++;
            ans += mp.getOrDefault(sum, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
