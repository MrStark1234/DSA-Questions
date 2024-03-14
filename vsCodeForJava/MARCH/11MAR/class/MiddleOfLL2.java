
//  Definition for singly-linked list.
public class MiddleOfLL2 {
    int val;
    MiddleOfLL2 next;

    MiddleOfLL2() {
    }

    MiddleOfLL2(int val) {
        this.val = val;
    }

    MiddleOfLL2(int val, MiddleOfLL2 next) {
        this.val = val;
        this.next = next;
    }
}

// Link : https://leetcode.com/problems/middle-of-the-linked-list/description/

class Solution {
    public MiddleOfLL2 middleNode(MiddleOfLL2 head) {
        MiddleOfLL2 slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // tortoise
            fast = fast.next.next; // rabbit
        }
        return slow;
    }
}