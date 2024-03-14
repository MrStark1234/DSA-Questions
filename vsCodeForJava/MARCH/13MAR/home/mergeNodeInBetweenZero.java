/*
Intuition
The code seems to be attempting to merge consecutive nodes with a value 
of 0 in a linked list.
Approach
Initialize two pointers, ptr1 and ptr2, pointing to the head of the 
linked list.
Traverse the linked list with ptr1:
If ptr1->val is 0, update the value of ptr2->val to the accumulated 
value and move ptr2 to the next node.
If ptr1->val is not 0, accumulate its value in the value variable.
Set ptr2->next to NULL to terminate the merged list.
Return the original head of the linked list.
Complexity
Time complexity:
Time complexity: O(n) where n is the number of nodes in the linked list.
Space complexity:
Space complexity: O(1) as the algorithm uses a constant amount of 
extra space regardless of the input size.
*/
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode ptr1 = head.next;
        ListNode ptr2 = head;
        int value = 0;

        while (ptr1 != null) {
            if (ptr1.val == 0) {
                ptr2.val = value;
                if (ptr1.next != null)
                    ptr2 = ptr2.next;
                value = 0;
            } else {
                value += ptr1.val;
            }
            ptr1 = ptr1.next;
        }

        ptr2.next = null;
        return head;
    }
}
