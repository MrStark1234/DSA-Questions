/*
Q4 - Number of Subarrays That Match a Pattern I
Question Link - https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/description/
Time Complexity - O((n-m)*m) ~ O(n*m)
Space Complexity - O(1)
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] pattern = new int[m];
            for (int i = 0; i < m; i++) {
                pattern[i] = sc.nextInt();
            }
            numOfSubarrayThatMatchThePatternI obj = new numOfSubarrayThatMatchThePatternI();
            System.out.println(obj.countMatchingSubarrays(nums, pattern));
        }
    }
}

class numOfSubarrayThatMatchThePatternI {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int st = i;
            int en = st + m;
            if (en >= n)
                break;

            // current subarray is between st and en
            // now check if current subarray follows the given pattern
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if ((pattern[j] == 1) && (nums[st + j + 1] <= nums[st + j]))
                    flag = false;
                if ((pattern[j] == 0) && (nums[st + j + 1] != nums[st + j]))
                    flag = false;
                if ((pattern[j] == -1) && (nums[st + j + 1] >= nums[st + j]))
                    flag = false;
            }
            if (flag)
                ans++;
        }
        return ans;
    }
}