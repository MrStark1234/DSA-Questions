/*

Question - Minimum Time to Repair Cars
Link - https://leetcode.com/problems/minimum-time-to-repair-cars/description/


The minimum time required can be 1; less than 1 is not possible.

The maximum time required can be calculated as (the minimum element of the given time array * cars * cars), if all cars were repaired by a single mechanic.

We use binary search to optimally choose the minimum time required to repair all cars.

Here, we assume an answer and attempt to verify whether our assumed answer is possible or not.

Let's suppose we assume 'mid' as the answer. Then, for every mechanic, rank[i] * n * n <= mid, where n * n = (rank[i] / mid), and n = sqrt(rank[i] / mid). This represents the number of cars repaired by the ith mechanic.

If the number of cars repaired by the 'mid' time is greater than or equal to the total number of cars, then our answer can be 'mid' time. However, it's possible that a time less than 'mid' can also be sufficient, so we reduce our end to decrease the 'mid'.

If the number of cars repaired by the 'mid' time is less than the total number of cars, then our answer cannot be 'mid' time. However, it's possible that a time greater than 'mid' can be sufficient, so we increase our start to increase 'mid'.


*/

class Solution {
    public boolean isPossible(long mid, int[] ranks, int cars) {
        long car = 0;
        for (int r : ranks) {
            long rem = (mid / r);
            car += Math.sqrt(rem);
        }
        return car >= cars;
    }

    public long repairCars(int[] ranks, int cars) {
        long ans = 0;
        long st = 0, ed = ranks[0] * (long) cars * cars;

        while (st <= ed) {
            long mid = (st + ed) / 2;

            if (isPossible(mid, ranks, cars)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }
}
