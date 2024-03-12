/*

Question - Minimum Speed to Arrive on Time
Link - https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/

Initially, when tackling this problem, we observe that our speed can range from 1 km/hr to 1e7 km/hr.
 To find the minimum speed, we initiate our search from 1 km/hr and stop when the conditions are met, returning the answer. 
 However, this approach proves inefficient, as it takes O(maxspeed) * O(size of array) time.


 Recognizing that the answer space is sorted, we opt for a binary search strategy.
  Here, each 'mid' represents our current speed under consideration.
   If the total time with the current speed is less than the required hours, it could potentially be a valid answer. 
   However, in pursuit of the minimum possible answer, we adjust 'hi' to 'mid - 1' to explore for a lower solution if feasible. 
 If not, the current answer stands as the minimum. 
 The second scenario arises when the total hours at the current speed exceed the given hours, rendering this speed unacceptable as the answer. 
 Therefore, we increment our speed ('lo = mid + 1') to attain a shorter time.

 One inportant thing  we don't need to calculate the ceiling time for the final station.

*/

class Solution {
    public boolean isPossible(int[] dist, int speed, double hour) {
        double ans = 0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            if (dist[i] % speed == 0) {
                ans += dist[i] / speed;
            } else {
                ans += (dist[i] / speed) + 1;
            }
        }
        ans += (double) dist[n - 1] / speed;
        return ans <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int st = 1, ed = 10000001;
        int ans = -1;

        while (st <= ed) {
            int mid = (st + ed) / 2;

            if (isPossible(dist, mid, hour)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return ans;
    }
}
