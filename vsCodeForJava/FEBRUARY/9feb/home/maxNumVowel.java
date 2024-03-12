/*
Q3 - Maximum Number of Vowels in a Substring of Given Length
Question Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

Time Complexity: O(n)
Space Complexity O(1) - (Ignoring the space taken up by input array)
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int k = sc.nextInt();
            String s = sc.next();
            Solution obj = new Solution();
            System.out.print(obj.maxVowels(s, k));
        }
    }
}

class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int ans = 0;
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += isVowel(s.charAt(i));
        }
        ans = Math.max(ans, curr);
        for (int i = k; i < n; i++) {
            curr += isVowel(s.charAt(i));
            curr -= isVowel(s.charAt(i - k));
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    private int isVowel(char c) {
        if (c == 'a')
            return 1;
        if (c == 'e')
            return 1;
        if (c == 'i')
            return 1;
        if (c == 'o')
            return 1;
        if (c == 'u')
            return 1;
        return 0;
    }
}
