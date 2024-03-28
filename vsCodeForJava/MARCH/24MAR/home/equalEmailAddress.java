/*
Question - Unique Email Addresses (Leetcode)
Link - https://leetcode.com/problems/unique-email-addresses/description/

Approach -
    For every email address in the list, format it according to the rules and add it to a set.
    If the email address is unique, it will be added to the map, increasing the size of the map.
*/

import java.util.HashMap;

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> mp = new HashMap<>();
        for (String email : emails) {
            StringBuilder real_email = new StringBuilder();
            boolean ignore = false;
            for (char c : email.toCharArray()) {
                if (c == '+' || c == '@') {
                    ignore = c == '+';
                    continue;
                }
                if (!ignore && c != '.') {
                    real_email.append(c);
                }
            }
            real_email.append(email.substring(email.indexOf('@')));
            mp.put(real_email.toString(), mp.getOrDefault(real_email.toString(), 0) + 1);
        }
        return mp.size();
    }
}
