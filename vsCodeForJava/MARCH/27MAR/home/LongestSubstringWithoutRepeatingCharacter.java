/*
Question - Longest Substring Without Repeating Characters (LeetCode)
Link - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Approach:
    Use a sliding window, suppose our window starts from i and ends at j.
    Create a map to count the frequency of characters between the window.
    When we increase the window size, meaning increasing j, we add the jth character to the map.
    If the frequency of the jth character is greater than 1, then we reduce the window size,
	 meaning we increase i and remove the ith character from the map until the frequency of the jth character is greater than 1.

    Average Time complexity - O(N) // N is the length of the input string
    Space Complexity - O(26) // There can be at most 26 characters
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        Map<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        while (j < n) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            while (mp.get(ch) > 1) {
                char removed = s.charAt(i++);
                mp.put(removed, mp.get(removed) - 1);
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
