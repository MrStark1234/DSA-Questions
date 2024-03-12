/*
Q1 - Find Smallest Letter Greater Than Target
Question Link - https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

Logic - Standard binary search 
Time Complexity - O(log(n))
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            char[] letters = new char[n];
            for (int i = 0; i < n; i++) {
                letters[i] = scanner.next().charAt(0);
            }
            char target = scanner.next().charAt(0);
            System.out.println(obj.nextGreatestLetter(letters, target));
        }
    }
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        int lo = 0;
        int hi = letters.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (letters[mid] > target) {
                ans = letters[mid];
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}