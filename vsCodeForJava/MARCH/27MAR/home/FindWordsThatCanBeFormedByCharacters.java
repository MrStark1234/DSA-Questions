/*
Question - Find Words That Can Be Formed by Characters (LeetCode)
Link - https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/

Approach:
    A count vector is created to store the count of characters from 'a' to 'z'.
    The frequency of each character in the chars string is calculated and stored in the counts vector using ASCII values.

    Each word in the words vector is checked if it can be formed from characters in chars.
    Now, in the function canForm, we check if it can be formed from characters in chars.
    A separate vector c is created for each word to count the frequency of characters.
    Character counts in c and counts are compared.
    If any character count in c exceeds the count in count, the word cannot be formed.
    Time complexity - O(chars.length + sum of the length of strings in vector words)
    Space Complexity - O(26) // for using a vector of size 26
*/

public class FindWordsThatCanBeFormedByCharacters {
    public boolean canForm(String word, int[] count) {
        int[] c = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            c[k]++;
            if (c[k] > count[k])
                return false;
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            count[chars.charAt(i) - 'a']++;
        }

        int res = 0;
        for (String word : words) {
            if (canForm(word, count))
                res += word.length();
        }
        return res;
    }
}
