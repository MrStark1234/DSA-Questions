/*
Q2 - Decode Ways
Question Link - https://leetcode.com/problems/decode-ways/
Logic - 
DP State:
dp[i] = number of ways of decoding the string till index i-1 (prefix of size i)

Base Cases: 
dp[0] = 1 -> There is only 1 way to decode an empty string
dp[1] = {
	0; if s[0] == '0' because no letter can be encoded as '0'
	1; otherwise
}

Transitions:
dp[i] = x + y, where:
x = {
	dp[i-1]; if substring of size 1 ending at index i-1 is a valid encoding
	0; otherwise
}
y = {
	dp[i-1]; if substring of size 2 ending at index i-1 is a valid encoding
	0; otherwise
}

Final Answer: dp[n]

Time Complexity: O(n) (n states and 2 transitions per state)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    private boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return false;
        int x = Integer.parseInt(s);
        return x >= 1 && x <= 26;
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0')
            dp[1] = 0;
        else
            dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            String s1 = s.substring(i - 1, i);
            String s2 = s.substring(i - 2, i);
            if (isValid(s1))
                dp[i] += dp[i - 1];
            if (isValid(s2))
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Solution obj = new Solution();
        System.out.println(obj.numDecodings(s));
        scanner.close();
    }
}
