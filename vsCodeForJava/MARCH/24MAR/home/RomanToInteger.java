/*
Question - Roman to Integer (Leetcode)
Link - https://leetcode.com/problems/roman-to-integer/description/

Approach -
    The key intuition lies in the fact that in Roman numerals, 
	when a smaller value appears before a larger value, it represents subtraction, 
	while when a smaller value appears after or equal to a larger value,
	 it represents addition.
    The unordered map value is created and initialized with mappings between 
	Roman numeral characters and their corresponding integer values.
	 For example, 'I' is mapped to 1, 'V' to 5, 'X' to 10, and so on.
    The variable ans is initialized to 0.
	 This variable will accumulate the final integer value of the Roman numeral string.
*/

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        // To store these values for convenience
        HashMap<Character, Integer> value = new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int ans = 0; // It will calculate the answer.
        int length = s.length(); // Size of the string

        for (int i = 0; i < length - 1; i++) {
            // If the current value is smaller than the next value, then do "-"
            if (value.get(s.charAt(i)) < value.get(s.charAt(i + 1))) {
                ans -= value.get(s.charAt(i));
            } else {
                ans += value.get(s.charAt(i));
            }
        }
        ans += value.get(s.charAt(length - 1));
        return ans;
    }
}
