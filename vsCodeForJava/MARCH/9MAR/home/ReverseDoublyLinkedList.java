// GFG -Reverse a Doubly Linked List
// https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
class Solution {
    public static Node reverseDLL(Node head) {
        // Two pointers are initialized: curr points to the current node starting from
        // the head,
        // and prev points to the previous node, initialized as NULL because there’s no
        // node before the head.
        Node curr = head;
        Node prev = null;

        // while loop continues until curr becomes NULL, i.e., until we’ve traversed the
        // entire list.
        while (curr != null) {
            // next pointer is created to store the next node of curr before we change
            // curr->next.
            Node next = curr.next;

            // next pointer of the current node is changed to the previous node, effectively
            // reversing the link.
            curr.next = prev;

            // if prev is not NULL, the prev pointer of the previous node is changed to the
            // current node.
            if (prev != null) {
                prev.prev = curr;
            }

            // prev and curr pointers are moved one step forward in the original direction
            // of the list.
            prev = curr;
            curr = next;
        }

        // After the list is reversed, the prev pointer of the new head node (which was
        // the last node of
        // the original list) is set to NULL
        if (prev != null) {
            prev.prev = null;
        }

        // prev pointer, which now points to the new head of the reversed list, is
        // returned.
        return prev;
    }
}