
// Definition for a ListNode.
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// No Link

class Solution {

    public ListNode copyList(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = new ListNode(head.val);

        ListNode cur = head;
        ListNode newCur = newHead;

        while (cur.next != null) {

            // Make a copy and do the attachment
            ListNode newNext = new ListNode(cur.next.val);
            newCur.next = newNext;

            // Move ahead
            cur = cur.next;
            newCur = newCur.next;
        }

        return newHead;
    }
}