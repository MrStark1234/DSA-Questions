// https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1

class Solution {
    static long countPainters(int[] arr, long time, int m) {
        long boardPainters = 0;
        long painters = 1;
        for (int i = 0; i < arr.length; i++) {
            if (boardPainters + arr[i] <= time) {
                boardPainters += arr[i]; // allocate board to current painter
            } else {
                painters++;
                boardPainters = arr[i]; // allocate board to next painter
            }
        }
        return painters;
    }

    static long minTime(int[] arr, int n, int k) {
        long low = arr[0];
        long high = 0;
        for (int i = 0; i < n; i++) { // find maximum and summation:
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        // apply binary search
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long painters = countPainters(arr, mid, k);
            if ((int) painters > k) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low;
    }
}