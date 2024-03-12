/*

Question - Minimum Time to Complete Trips (Leetcode)
Link  - https://leetcode.com/problems/minimum-time-to-complete-trips/description/


The minimum time required can be 1; less than 1 is not possible.

The maximum time required can be (the minimum element of the given time array * total trips).

We use binary search to optimally choose the minimum time required to complete the total trips.

Here, we assume an answer and attempt to verify whether our assumed answer is possible or not.

If the number of trips completed by the 'mid' time is greater than or equal to the total trips, then our answer can be 'mid' time. However, it's possible that a time less than 'mid' can also be sufficient, so we reduce our end to decrease the 'mid'.

If the number of trips completed by the 'mid' time is less than the total trips, then our answer cannot be 'mid' time. However, it's possible that a time greater than 'mid' can be sufficient, so we increase our start to increase 'mid'.


*/

class Solution {
    public boolean isPossible(long mid, int totalTrips, int[] time) {
        long ct = 0;
        for (int i = 0; i < time.length; i++) {
            ct += mid / time[i];
        }
        return ct >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long st = 0, ed = (time[0] + 0L) * totalTrips;
        long ans = 0;
        while (st <= ed) {
            long mid = (st + ed) / 2;

            if (isPossible(mid, totalTrips, time)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }
}
