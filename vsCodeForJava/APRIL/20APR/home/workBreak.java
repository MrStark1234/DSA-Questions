// https://leetcode.com/problems/word-break/description/

// We use a boolean vector dp[]. dp[i] is set to 
// true if a valid word (word sequence) ends there.
// The optimization is to look from current position
// i back and only substring and do dictionary look 
// up in case the preceding position j with dp[j] == true 
// is found.

import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0)
            return false;

        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j]) {
                    String word = s.substring(j, i);
                    if (dict.contains(word)) {
                        dp[i] = true;
                        break; // next i
                    }
                }
            }
        }

        return dp[s.length()];
    }
}