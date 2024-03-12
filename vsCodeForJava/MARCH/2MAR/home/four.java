/*
Q4 - Find Minimum in Rotated Sorted Array
Question Link - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

Logic - 
Let'd divide the input array into two parts:
	1. Part which was shifted to the right: call it shifted part - suffix
	2. Part which rotated to left side : call it rotated part - prefix

Our aim is to find first element of the shifted part

Now in each iteration of binary search, one of the two cases arise:
	1. mid lies in rotated part - we know that our target lies in the right part
	2. mid lies in shifted part - mid can be our ans or can be smaller

How do we check if current mid lies in rotated part?
just check if arr[mid] > arr[n-1]

Time Complexity - O(log(n))
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(obj.findMin(nums));
        }
    }
}

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int ans = 0; // Initializing ans to 0, as it will be updated in the loop
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[n - 1]) {
                lo = mid + 1;
            } else {
                ans = nums[mid];
                hi = mid - 1;
            }
        }
        return ans;
    }
}
