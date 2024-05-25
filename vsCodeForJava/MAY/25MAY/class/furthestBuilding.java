// Link : https://leetcode.com/problems/furthest-building-you-can-reach/

import java.util.*;

class Solution {
    public int furthestBuilding(int[] h, int b, int l) {
        PriorityQueue<Integer> mn = new PriorityQueue<>();
        int n = h.length;

        for (int i = 0; i + 1 < n; ++i) {
            if (h[i + 1] < h[i])
                continue; // nothing required to be done

            int val = h[i + 1] - h[i];
            mn.add(val); // Trying to go to i+1 using a ladder

            if (mn.size() > l) { // More than l ladders used
                // We should've used bricks for the min height difference
                int minHtDiff = mn.poll();

                if (b >= minHtDiff)
                    b -= minHtDiff;
                else
                    return i; // Can't go to i + 1
            }
        }

        return n - 1;
    }
}