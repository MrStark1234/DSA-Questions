import java.util.*;

// Link : https://leetcode.com/problems/binary-search/description/

// Time : O(LogN)
// Space : O(LogN)

class Solution {
    int recursiveBinarySearch(int nums[], int l, int r, int target) {
        if (l > r)
            return -1;

        int m = (l + r) / 2;

        if (nums[m] == target)
            return m;

        if (nums[m] < target)
            return recursiveBinarySearch(nums, m + 1, r, target);

        return recursiveBinarySearch(nums, l, m - 1, target);
    }

    public int search(int[] nums, int target) {
        return recursiveBinarySearch(nums, 0, nums.length - 1, target);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.search(arr, target));
        sc.close();
    }
}