/*

Question - Queries for Number of Palindromes
Link - https://codeforces.com/contest/245/problem/H


Approach-
    First, calculate whether each substring is a palindrome for all substrings.
    Pre-calculate the answer for every substring.

*/

import java.io.*;

public class queriesOfNumberOfPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        int q = Integer.parseInt(reader.readLine());
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] ispal = new boolean[n][n];

        // Calculate if the substring from `st` to `end` is a palindrome or not.
        for (int i = 0; i < n; i++) {
            // Odd length
            int st = i, end = i;
            while (st >= 0 && end < n && s.charAt(st) == s.charAt(end)) {
                ispal[st][end] = true;
                st--;
                end++;
            }

            // Even length
            st = i - 1;
            end = i;
            while (st >= 0 && end < n && s.charAt(st) == s.charAt(end)) {
                ispal[st][end] = true;
                st--;
                end++;
            }
        }

        // Now pre-calculate the number of palindromic substrings between every possible
        // i and j.
        for (int len = 0; len < n; len++) {
            for (int i = 0, j = i + len; j < n; j++, i++) {
                if (len == 0) {
                    dp[i][j] = 1; // If len==0, it means i==j, which is always a palindrome.
                } else {
                    if (ispal[i][j]) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + 1; // To calculate the answer for i
                                                                                       // to j, first calculate the
                                                                                       // answer for i to j-1 and i+1 to
                                                                                       // j, then remove the common
                                                                                       // [i+1,j-1] part.
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
            }
        }

        while (q-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            int l = Integer.parseInt(tokens[0]) - 1;
            int r = Integer.parseInt(tokens[1]) - 1;
            writer.write(dp[l][r] + "\n");
        }

        writer.flush();
    }
}
