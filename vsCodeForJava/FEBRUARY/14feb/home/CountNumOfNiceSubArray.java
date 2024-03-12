// Count Number of Nice Subarrays
// https://leetcode.com/problems/count-number-of-nice-subarrays/description/

/*

Consider the window with k prime numbers, the number of evens on either side
 are variables, Maintain evens on left and right of every odd numbers, 
 ans is sum of (evens on left of first number + 1 * evens on right of last number + 1).
 Store the evens on left of every number in a vector and evens on the right of last element in last.
 Slide a window of size k , add (even[i]+1 * even[i+k]+1 ) to the sum.

*/
import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // List to store the evens between odd numbers
        List<Integer> even = new ArrayList<>();
        int temp = 0, ans = 0;

        // Store Evens between odds
        for (int num : nums) {
            if (num % 2 == 0)
                temp++;
            else {
                even.add(temp);
                temp = 0;
            }
        }
        even.add(temp);

        int m = even.size();

        // sliding window to count number of subarrays
        for (int i = 0; i < m - k; i++) {
            ans += (even.get(i) + 1) * (even.get(i + k) + 1);
        }

        return ans;
    }
}