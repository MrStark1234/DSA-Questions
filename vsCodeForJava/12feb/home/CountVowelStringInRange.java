
/*
 * 
 * Question- Count Vowel Strings in Ranges(Leetcode)
 * Link-
 * https://leetcode.com/problems/count-vowel-strings-in-ranges/description/
 * 
 * Approach-
 * We can convert this problem to prefix sum range query.
 * If we have a word which have first and last letter as vowel then assign it to
 * 1 otherwise 0.
 * Now take prefix sum and and answer the query in o(1).
 * 
 * TC-> O(N+M) N->array length and M->query array length
 * SC-> O(N)
 * 
 */

class CountVowelStringInRange {
    public boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                pre[i] = 1;
            } else {
                pre[i] = 0;
            }
            if (i >= 1) {
                pre[i] += pre[i - 1];
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = pre[r];
            } else {
                ans[i] = pre[r] - pre[l - 1];
            }
        }
        return ans;
    }
}
