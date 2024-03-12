import java.util.*;

// Link : https://leetcode.com/problems/binary-search/description/

// Time : O(LogN)
// Space : O(1)

class Solution {
    int iterativeBinarySearch(int nums[], int l, int r, int target) {
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target)
                return m;

            if (nums[m] > target) // go to [l, m - 1];
                r = m - 1;

            else // go to [m + 1, r];
                l = m + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return iterativeBinarySearch(nums, 0, nums.length - 1, target);
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
