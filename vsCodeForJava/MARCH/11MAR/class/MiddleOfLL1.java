
//  Definition for singly-linked list.
public class MiddleOfLL1 {
    int val;
    MiddleOfLL1 next;

    MiddleOfLL1() {
    }

    MiddleOfLL1(int val) {
        this.val = val;
    }

    MiddleOfLL1(int val, MiddleOfLL1 next) {
        this.val = val;
        this.next = next;
    }
}

// Link : https://leetcode.com/problems/middle-of-the-linked-list/description/

/*
 * Time : O(N)
 * Space : O(N/K)
 */

class Solution {
    int length(MiddleOfLL1 head) {
        int len = 0;
        MiddleOfLL1 cur = head;
        while (cur != null) {
            cur = cur.next;
            len += 1;
        }
        return len;
    }

    public MiddleOfLL1 middleNode(MiddleOfLL1 head) {
        int N = length(head);
        MiddleOfLL1 cur = head;
        for (int i = 0; i < N / 2; ++i)
            cur = cur.next;
        return cur;
    }
}