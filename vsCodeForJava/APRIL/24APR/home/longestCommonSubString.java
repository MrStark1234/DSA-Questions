//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
// GFG- Longest Common Substring

/* 
  
  The sequence of characters in the substring must be consecutive.
  dp[n+1][m+1]

We have two conditions:
if(S1[i-1] != S2[j-1]), 
     the characters don’t match, therefore the consecutiveness of characters is broken. 
	 So we set the cell value (dp[i][j]) as 0.

if(S1[i-1] == S2[j-1]), 
    then the characters match and we simply set its value to 1+dp[i-1][j-1]. 
	We have done so because dp[i-1][j-1] gives us the longest common substring till 
	the last cell character (current strings -{matching character}). As the current 
	cell’s character is matching we are adding 1 to the consecutive chain.

Now our table contains length of all common substrings and since substrings can be 
found anywhere in the table, not necessarily at the end so we just need traverse the 
table again and find the max element that will be the longest common substring

*/

class Solution {
    int longestCommonSubstr(String s1, String s2, int n, int m) {
        // Create a 2D DP table with dimensions (n+1) x (m+1)
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1]; // Characters match, increment substring length
                    dp[i][j] = val; // Update the DP table
                } else
                    dp[i][j] = 0; // Characters don't match, substring length becomes 0
            }
        }

        int maxLen = 0; // Now finding the max element
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                maxLen = Math.max(maxLen, dp[i][j]);
        }
        return maxLen;
    }
}