import java.util.*;

// Time : O(LogN)
// Space : O(1)

class Solution {
    int ubUtil(int nums[], int l, int r, int target) {
        int ans = nums.length;
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] > target) {
                ans = m; // save m in answer.
                r = m - 1; // but still keep searching in [l, m - 1];
            }

            else // go to [m + 1, r];
                l = m + 1;
        }
        return ans;
    }

    int lbUtil(int nums[], int l, int r, int target) {
        int ans = nums.length;
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] >= target) { // This 'if' is the only diff b/w ub & lb
                ans = m; // save m in answer.
                r = m - 1; // but still keep searching in [l, m - 1];
            }

            else // go to [m + 1, r];
                l = m + 1;
        }
        return ans;
    }

    public int upperBound(int[] nums, int target) {
        return ubUtil(nums, 0, nums.length - 1, target);
    }

    public int lowerBound(int[] nums, int target) {
        return lbUtil(nums, 0, nums.length - 1, target);
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
        System.out.println("LB" + ": " + sol.lowerBound(arr, target));
        System.out.println("UB" + ": " + sol.upperBound(arr, target));
        sc.close();
    }
}
