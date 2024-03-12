/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

We know that eventually we have to shoot down every 
balloon, so for each ballon there must be an arrow whose 
position is between balloon x-start and x-end inclusively.

So what position should we pick each time? 
We should shoot as to the right as possible, because 
since balloons are sorted, this gives you the best chance 
to take down more balloonsn with minimum no of shots. 
And then we can calculate the no of shots taken, 
if start of next element is greater than end of prev one, a new
shot will be required.

TC- O(nlogn)
Sc- O(1)
*/

import java.util.Arrays;

class Solution {
    // Finds the minimum number of arrows needed to burst all balloons
    public int findMinArrowShots(int[][] points) {
        // Sort the balloons by the end position of the arrow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // Initialize the number of arrows needed to 1
        int result = 1;
        // Set the index of the previously burst balloon to 0
        int previous = 0;

        // Iterate through all balloons
        for (int current = 1; current < points.length; current++) {
            // If the start position of the current balloon is after the end position of the
            // arrow that burst the previous balloon,
            // then a new arrow is needed to burst the current balloon
            if (points[current][0] > points[previous][1]) {
                result++;
                // Update the index of the previously burst balloon
                previous = current;
            }
        }
        return result;
    }
}
