
//  * Definition for singly-linked list.
public class reverseInKGroup {
    int val;
    reverseInKGroup next;

    reverseInKGroup() {
    }

    reverseInKGroup(int val) {
        this.val = val;
    }

    reverseInKGroup(int val, reverseInKGroup next) {
        this.val = val;
        this.next = next;
    }
}

// Link : https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution {
    void reverse(reverseInKGroup head, reverseInKGroup tail) {
        // We just need to reverse the connections
        reverseInKGroup cur = head, prev = null;
        while (cur != tail) {
            reverseInKGroup originalNextNode = cur.next;
            cur.next = prev; // Connection reversed

            // Move ahead
            prev = cur;
            cur = originalNextNode;
        }

        // Correct the connection for tail as well
        cur.next = prev;
    }

    public reverseInKGroup reverseKGroup(reverseInKGroup head, int k) {
        if (k == 1 || head == null || head.next == null)
            return head;

        // Find [beg, end] such that beg points to
        // 1st node and end points to kth node
        reverseInKGroup beg = head, end = head;

        // Go ahead k-1 times to go to the kth node (1-based)
        for (int i = 0; i < k - 1; ++i) {
            end = end.next;

            // If less than k nodes available, do nothing
            if (end == null)
                return head;
        }

        // Get the head of further k-groups in reversed order
        reverseInKGroup nextHead = reverseKGroup(end.next, k);

        // Now, reverse the current k-group, and make relevant connection
        reverse(beg, end);
        beg.next = nextHead;

        return end;
    }
}