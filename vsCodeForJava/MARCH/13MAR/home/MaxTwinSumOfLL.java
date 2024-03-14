
/*
Intuition
You have to initialize a vector and put all values from list in it. After that just iterate through half of a vector and on each iteration compare sum of vals[i] and vals[len - i] with result value. (len - length of a vector)

Approach
Initialize vector.
Go through Linked List and put each value in vector. Also increment "len" variable.
Iterate through vector from 0 to len / 2 (half of a vector).
Compare sum of vals[i] and vals[len - i] with ans variable and store maximum between them.
Profit.
Complexity
Time complexity: O(n)

Space complexity: O(n)
*/
import java.util.ArrayList;

class Solution {
    public int pairSum(ListNode head) {
        int ans = 0, len = 0;
        ArrayList<Integer> vals = new ArrayList<>();

        while (head != null) {
            len++;
            vals.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < len / 2; ++i) {
            ans = Math.max(ans, vals.get(i) + vals.get(len - i - 1));
        }

        return ans;
    }
}
