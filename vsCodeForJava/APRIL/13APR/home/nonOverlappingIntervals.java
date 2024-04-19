/*
Q3 - Non-overlapping Intervals
Question Link - https://leetcode.com/problems/non-overlapping-intervals/description/

Logic - 
We sort the intervals in ascending order of start values.
While maintaining the end value (call it currEnd), we traverse the intervals.
Two cases may arise:
	1. if currEnd <= intervals[i][0] - It means no overlap and we dont need to delete any interval.
	We just update the currEnd value.

	2. if currEnd > intervals[i][0] - It means overlap and we need to delete some interval to remove the overlap.
	Greedily, we remove that interval which has the greater end value to minimise the chances of further overlap. 

Time Complexity - O(n*log(n))
Space Complexity - O(1) 
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = scanner.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println(obj.eraseOverlapIntervals(intervals));
        scanner.close();
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int currEnd = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= currEnd) {
                currEnd = intervals[i][1];
            } else {
                currEnd = Math.min(currEnd, intervals[i][1]);
                ans++;
            }
        }
        return ans;
    }
}
