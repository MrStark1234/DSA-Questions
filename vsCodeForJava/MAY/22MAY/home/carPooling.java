// https://leetcode.com/problems/car-pooling/

// We try to simulate each and every point in which 
// we have some passengers either increasing or decreasing.
// The passengers who are in the priority queue are the 
// ones who are getting out of the car. Priority queue 
// store {end, passengers} in it. We iterate through the 
// trips array which is sorted with respect to the 
// starting points. When we reach a point, we first 
// try to remove all the passengers which have been in 
// the car till that point by iterating through the 
// priority queue and removing all the points smaller 
// than the current point. Then, we add the current
// number of passengers in the count and check if the
// current number of passengers in the car exceeds the 
// capacity. If it does, then return false otherwise push 
// the ending point of this try and continue on to the
// next point at which car is pooled. If the simulation 
// goes without exceeding capacity, the answer is true.

import java.util.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;

        // Sort trips based on the comparator logic
        Arrays.sort(trips, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Priority queue to keep track of ongoing trips, sorted by end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int curr = 0; // Current passengers in car
        for (int i = 0; i < n; i++) {
            // Remove all completed trips and their passengers from curr
            while (!pq.isEmpty() && pq.peek()[0] <= trips[i][1]) {
                curr -= pq.poll()[1];
            }

            // Add the current trip to the priority queue
            pq.add(new int[] { trips[i][2], trips[i][0] });
            curr += trips[i][0];

            // If the current number of passengers exceeds capacity, return false
            if (curr > capacity) {
                return false;
            }
        }
        return true;
    }
}
