
/*
 * Q3 - Sort An Array
 * Question Link - https://leetcode.com/problems/sort-an-array/
 * 
 * Logic -
 * Standard Merge Sort algorithm as discussed in the class
 * 
 * Time Complexity - O(n*log(n))
 * Space Complexity - O(n)
 * 
 * Since the space complexity of the merge2SortedArrays function
 * dominates the space complexity of the sortArray function,
 * we can say that the overall space complexity of the provided code is O(N),
 * where N is the number of elements in the input nums array.
 * This is because the recursive stack space used by the function calls is
 * proportional to the depth of the recursion tree, which is log(N)
 * in the worst case for merge sort, but it's not considered in the
 * space complexity analysis here.
 */

import java.util.*;

class sortAnArray {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            Solution obj = new Solution();
            int[] ans = obj.sortArray(nums);
            for (int i = 0; i < n; i++)
                System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    public int[] merge2SortedArrays(int left[], int right[]) {
        int i = 0, j = 0, k = 0;
        int ans[] = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                ans[k] = left[i];
                i++;
            } else {
                ans[k] = right[j];
                j++;
            }
            k++;
        }

        // remaining elements to be pushed from left
        while (i < left.length) {
            ans[k] = left[i];
            i++;
            k++;
        }

        // remaining elements to be pushed from right
        while (j < right.length) {
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // base case
        if (n == 1)
            return nums;

        int left[] = Arrays.copyOfRange(nums, 0, n / 2); // [0, n/2)
        int right[] = Arrays.copyOfRange(nums, n / 2, n); // [n/2, n)

        left = sortArray(left); // recursive call to sort left half
        right = sortArray(right); // recursive call to sort right half

        return merge2SortedArrays(left, right);
    }
}
