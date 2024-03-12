/*

Question - Minimum Number of Days to Make m Bouquets
Link - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

Firstly, we have n flowers and we need to make m bouquets 
with k flowers each where all the flowers must be adjacent

So, if n < m*k(total number of flowers needed), then it is not possible
to make all bouquets, so answer will be -1 in this case

Now, we can perform binary search on answer i.e. if there is a 
minimum day such that we can make a bouquet on that day, then 
it is possible to make a bouquet on all the days that lies ahead
of that day. So, we can perform binary search on the number of days

Now, for a given number of day d in binary search, the number of adjacent flowers 
which are blossomed can be included in bouquet. So, count the 
total number of adjacent flowers which are not picked for each day
and compare the number of bouquets that can be formed

*/

class Solution {
    public int countBouquet(int[] bloomDay, int k, int day) {
        int bouquets = 0, flowers = 0;
        for (int x : bloomDay) {
            if (x <= day) {
                flowers++;
            } else {
                flowers = 0;
            }

            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }

        return bouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long n = bloomDay.length;
        long total = (long) m * (long) k;
        if (n < total) {
            return -1;
        }

        int left = 0, right = (int) 1e9 + 1, day;

        while (left + 1 < right) {
            day = (left + right) / 2;
            if (countBouquet(bloomDay, k, day) < m) {
                left = day;
            } else {
                right = day;
            }
        }
        return right;
    }
}
