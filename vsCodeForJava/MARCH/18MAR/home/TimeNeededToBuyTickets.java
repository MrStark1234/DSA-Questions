// https://leetcode.com/problems/time-needed-to-buy-tickets/description/

// We know the value of k-th element. Elements before k (and 
// the element itself) will appear in the line min(t[k], t[i])
// times. All elements after k will appear in the line 
// min(t[k] - 1, t[i]) times.

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        int sz = tickets.length;
        int cap = tickets[k];
        for (int i = 0; i < sz; ++i) {
            res += Math.min(cap - (i > k ? 1 : 0), tickets[i]);
        }
        return res;
    }
}