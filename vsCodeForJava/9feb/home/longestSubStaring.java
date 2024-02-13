/*
Q5 - Length of the longest substring
Question Link: https://www.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1

Time Complexity: O(n)
Space Complexity O(26) ~ O(1)
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.print(obj.longestUniqueSubsttr(s));
        }
    }
}

class Solution {
    int longestUniqueSubsttr(String S) {
        int n = S.length();
        int ans = 1;
        int i = 0;
        int j = 0;
        int[] freq = new int[26];
        freq[S.charAt(0) - 'a']++;
        while (j < n - 1) {
            j++;
            freq[S.charAt(j) - 'a']++;
            while (freq[S.charAt(j) - 'a'] == 2) {
                freq[S.charAt(i) - 'a']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
