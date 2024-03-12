/*
https://leetcode.com/problems/maximum-units-on-a-truck/description/


We have to maximise the number of units that can be 
stored in the truck, keeping in mind the number of box that can
be put in thr truck. So we can sort the boxTypes vector
on the basis of no of units per box. This is greedy approach,
as for the given number of boxes we are first choosing the box
having more units.

*/

import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] B, int T) {
        Arrays.sort(B, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] b : B) {
            int count = Math.min(b[0], T);
            ans += count * b[1];
            T -= count;
            if (T == 0)
                return ans;
        }
        return ans;
    }
}
