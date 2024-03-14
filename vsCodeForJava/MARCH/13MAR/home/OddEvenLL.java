/*
Firstly, thanks for refering to my solution :)

APPROACH :

The idea is to split the linked list into 2 : one containing all odd nodes and other containing all even nodes. And finally, attach the even node linked list at the end of the odd node linked list.
To split the linked list into even nodes & odd nodes, we traverse the linked list and keep connecting the consecutive odd nodes and even nodes (to maintain the order of nodes) and save the pointer to the first even node.
Finally, we insert all the even nodes at the end of the odd node list.
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = head.next;

        while (odd.next != null && even.next != null) {
            odd.next = even.next; // Connect all odds
            even.next = odd.next.next; // Connect all evens
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenStart; // Place the first even node after the last odd node
        return head;
    }
}
