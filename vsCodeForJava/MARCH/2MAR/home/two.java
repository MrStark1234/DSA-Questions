/*
Q2 - Find First and Last Position of Element in Sorted Array
Question Link - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Logic - 
Divide the problem into two smaller subproblems:
	1. Find first occurence of target - lower_bound
	2. Find last occurence of target - upper_bound-1

So we need to apply binary search two times

Time Complexity - O(2*log(n))
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int[] result = obj.searchRange(nums, target);
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        // First search to find first occurrence of target
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                if (nums[mid] == target)
                    ans[0] = mid;
                hi = mid - 1;
            }
        }

        // Second search to find last occurrence of target
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                if (nums[mid] == target)
                    ans[1] = mid;
                lo = mid + 1;
            }
        }

        return ans;
    }
}
