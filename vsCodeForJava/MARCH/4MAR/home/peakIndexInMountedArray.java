/*
Approach
There is only one index 'i' (i.e. Peak index) in entire array at which the following condition is satisfied:
a[i] > a[i-1] && a[i] > a[i+1]
So, we can find this index using BINARY SEARCH.

Left array part of peak index will be sorted in increasing order and right array part of peak index will be sorted in decreasing order.

Steps
Check the condition for peak index at mid if it is true then return mid
if a[mid]>a[mid-1] then it means mid lies on left part of peak index, so set low to mid
if a[mid]>a[mid+1] then it means mid lies on right part of peak index, so set high to mid
Complexity
Time complexity: O(logn)O(log n)O(logn)
Space complexity: O(1)O(1)O(1)
*/
class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int n = a.length;
        int l = 0, h = n - 1;
        int m = 0;
        while (l < h) {
            m = (l + h) / 2;
            if ((a[m] > a[m - 1]) && (a[m] > a[m + 1])) {
                return m;
            }
            if (a[m] > a[m - 1]) {
                l = m;
            } else if (a[m] > a[m + 1]) {
                h = m;
            }
        }
        return m;
    }
}
