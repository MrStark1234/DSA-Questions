// leetcode - 567. Permutation in String
// https://leetcode.com/problems/permutation-in-string/description/

/*
first, we need to create a hashmap to keep track of how many times each 
character occurs in s1.
Then, we will use a sliding window approach in s2, and use a second 
hashmap to keep track of the characters in the current window.
For each window, we will compare the two hashmap and if they are equal,
 it means that s2 contains a permutation of s1.
If we reach the end of s2 without finding a permutation, 
  then we return false.
We also need to update the second hashmap by removing the character at 
the start of the window and adding the character at the end of the window 
for each iteration of the sliding window.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (s1Count.equals(s2Count))
                return true;

            char startChar = s2.charAt(i);
            char endChar = s2.charAt(i + s1.length());
            // decrease the count of starting character
            s2Count.put(startChar, s2Count.get(startChar) - 1);
            if (s2Count.get(startChar) == 0) {
                s2Count.remove(startChar);
            }
            s2Count.put(endChar, s2Count.getOrDefault(endChar, 0) + 1);
        }

        return s1Count.equals(s2Count);
    }
}