// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

// We have to first map each number to the possible letter it can have. 
// We can use hashmaps for that. Eg - 2 will be mapped with a,b,c as these
// are the possible letters to be pressed when 2 is pressed. 
// So, we will iterate in the given string, for each letter, 
// try out all the letters that are possible and then move on to the next index
//  of digits string in the recursive code.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        backtrack(0, digits, "", digitToChar, res);
        return res;
    }

    private void backtrack(int index, String digits, String curStr, Map<Character, String> digitToChar,
            List<String> res) {
        if (digits.length() == 0) {
            return;
        }

        if (index == digits.length()) {
            res.add(curStr);
            return;
        }
        char digit = digits.charAt(index);
        String chars = digitToChar.get(digit);
        for (char c : chars.toCharArray()) {
            backtrack(index + 1, digits, curStr + c, digitToChar, res);
        }
    }
}
