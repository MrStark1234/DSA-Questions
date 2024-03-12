
/*
 * Q2 - Minimum Common Value
 * Question Link -
 * https://leetcode.com/problems/minimum-common-value/description/
 * 
 * Logic -
 * We are already given sorted arrays.
 * Lets define two pointers i and j which traverse nums1 and nums2 respectively
 * starting from index 0.
 * 
 * Now three cases arise:
 * 1. nums1[i] > nums2[j] - There is no element in nums1 which is equal to
 * nums2[j]
 * ~ increment j
 * 2. nums1[i] < nums2[j] - There is no element in nums2 which is equal to
 * nums1[j]
 * ~ increment i
 * 3. nums1[i] == nums2[j] - Found the minimum common element
 * ~ return
 * 
 * Time Complexity - O(n+m)
 * Space Complexity - O(1) ~ ignoring the space occupied by input arrays
 */

import java.util.*;

class minimumCommonValues {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums1 = new int[n];
            int[] nums2 = new int[m];
            for (int i = 0; i < n; i++) {
                nums1[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                nums2[i] = scanner.nextInt();
            }
            Solution obj = new Solution();
            System.out.println(obj.getCommon(nums1, nums2));
        }
    }
}

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i, j;
        i = j = 0;
        while (i < n && j < m) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                return nums1[i];
            }
        }
        return -1;
    }
}
