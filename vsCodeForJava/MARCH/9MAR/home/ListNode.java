// Leetcode - 206.Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/

/*
The approach is to traverse the linked list iteratively. 
Initially, prev is set to NULL, and curr is set to the head of the list. 
During the traversal, the next pointer of the curr node is reversed to point
 to the prev node. Then, the prev and curr pointers are moved one step 
 forward in the list. This process continues until curr becomes NULL, 
 at which point, prev points to the new head of the reversed list.


To visualize the process of reversing the linked list, 
consider the following example input: 1 -> 2 -> 3 -> 4 -> 5.

Initially, prev = NULL and curr = 1.

In the first iteration, curr->next is stored in a temporary variable temp. 
Then, curr->next is set to prev, and both prev and curr move one step forward: prev = 1, curr = 2.

This process continues, effectively reversing the pointers: 2 -> 1 -> NULL.

The same steps are applied to the next nodes, resulting in the reversed list: 5 -> 4 -> 3 -> 2 -> 1
*/

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // store the address of the next of current
            ListNode temp = curr.next;
            // make the current node point to prev
            curr.next = prev;
            // update prev to current and current to temp
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
