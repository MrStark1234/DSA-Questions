/*
Q2 - Find Greatest Common Divisor of Array
Question Link - https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/

Logic - 
Straightforward logic:
	1. Find minimum element
	2. Find maximum element
	3. Find gcd using Euclid's algorithm

Time Complexity - O(n+log(min(nums[i])))
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.findGCD(nums));
        scanner.close();
    }
}

class Solution {
    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public int findGCD(int[] nums) {
        int minNum = 1001;
        int maxNum = 0;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        return gcd(minNum, maxNum);
    }
}
