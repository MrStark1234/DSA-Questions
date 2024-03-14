
//  * Definition for singly-linked list.
public class LLIntersection1 {
    int val;
    LLIntersection1 next;

    LLIntersection1(int x) {
        val = x;
        next = null;
    }
}

// Link :
// https://leetcode.com/problems/intersection-of-two-linked-lists/description/

class Solution {
    int getLength(LLIntersection1 head) {
        LLIntersection1 cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len += 1;
        }
        return len;
    }

    LLIntersection1 giveTheEdge(LLIntersection1 cur, int iterations) {
        for (int i = 0; i < iterations; ++i)
            cur = cur.next;
        return cur;
    }

    public LLIntersection1 getIntersectionNode(LLIntersection1 headA, LLIntersection1 headB) {
        int l1 = getLength(headA);
        int l2 = getLength(headB);

        LLIntersection1 cur1 = headA, cur2 = headB;

        if (l1 > l2) {
            cur1 = giveTheEdge(headA, l1 - l2);
        } else {
            cur2 = giveTheEdge(headB, l2 - l1);
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }
}
