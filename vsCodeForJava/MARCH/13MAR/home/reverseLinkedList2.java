/*
Intuition
If left is 1 and right is the last node in the linked list, it would be same as the 206. Reverse Linked List problem.

So, with a few tweaks we can use the same solution as that of the simple linked list reversal.

Approach
The follow up requires us to solve the problem in a single pass.
So, we need to maintain a counter variable to check if we have reached the left or right position.

add a check if counter == left,
note positions where the reverse list needs to be joined to the original list.

Linked list reversal:

Maintain three variables prev, curr and next.
curr.next = prev, // This points the node to its prev node so that the list can be reversed
prev = curr and
curr = next
At last, perform
joinFromLeft.next = prev.
joinToRight.next = curr.

Complexity
Time complexity: O(n)

Space complexity: O(1)

*/

// Definition for singly-linked list.
public class reverseLinkedList2 {
    int val;
    reverseLinkedList2 next;

    reverseLinkedList2() {
    }

    reverseLinkedList2(int val) {
        this.val = val;
    }

    reverseLinkedList2(int val, reverseLinkedList2 next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public reverseLinkedList2 reverseBetween(reverseLinkedList2 head, int left, int right) {
        if (head == null || left == right)
            return head;

        int count = 1;
        reverseLinkedList2 pseudoHead = new reverseLinkedList2();
        pseudoHead.next = head;

        reverseLinkedList2 prev = pseudoHead;
        reverseLinkedList2 curr = head;
        reverseLinkedList2 next;

        reverseLinkedList2 joinFromLeft = null;
        reverseLinkedList2 joinToRight = null;

        // write logic in a single pass as per the follow up question
        while (curr != null && count <= right) {
            next = curr.next;
            if (count == left) {
                // record pointers where the reversed list should be attached.
                // left - 1 node would be pointing to the new Reversed head.
                // left node will be the new tail and would point to the
                // remaining nodes
                joinFromLeft = prev;
                joinToRight = curr;
            }
            if (count >= left) {
                // reverse node logic
                curr.next = prev;
            }
            prev = curr;
            curr = next;
            count++;
        }
        joinFromLeft.next = prev;
        joinToRight.next = curr;
        return pseudoHead.next;
    }
}
