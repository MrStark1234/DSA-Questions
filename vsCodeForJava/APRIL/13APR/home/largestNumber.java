/*
Q6 - Largest Number
Question Link - https://leetcode.com/problems/largest-number/description/

Logic - 
Since the greatest number is also the lexicographically greatest string,
we can compare two numbers based on the lexicographical order of the two possible strings they create 
after their concatenation.

Time Complexity - O(n*log(n)*log(nums[i]))
Space Complexity - O(n) 
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.largestNumber(nums));
        scanner.close();
    }
}

class Solution {
    private static class NumComparator implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            String s = Integer.toString(x);
            String t = Integer.toString(y);
            if ((s + t).compareTo(t + s) > 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public String largestNumber(int[] nums) {
        Integer[] numObjects = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numObjects[i] = nums[i];
        }
        Arrays.sort(numObjects, new NumComparator());
        StringBuilder sb = new StringBuilder();
        for (int num : numObjects) {
            sb.append(num);
        }
        String ans = sb.toString();
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans;
    }
}
