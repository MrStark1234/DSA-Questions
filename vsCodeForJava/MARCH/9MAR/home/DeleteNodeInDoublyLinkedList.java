// GFG - Delete node in Doubly Linked List
// https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1

class Solution {
    // function returns the head of the linkedlist
    Node deleteNode(Node head, int x) {
        int cnt = 1;
        Node curr = head;
        Node prev = null;
        // if x==1 means delete the head
        if (x == 1) {
            // set the prev of next node to null and return the next node
            curr.next.prev = null;
            return curr.next;
        }
        // Traverse until target node is reached
        while (cnt < x) {
            cnt++;
            curr = curr.next;
        }
        // find the left and right node of our current node
        // left_node , curr_node,right_node
        Node right = curr.next;
        Node left = curr.prev;
        // now delete the curr node and connect the left node node and right node
        left.next = right;
        // if current node is not the last node of linked list then the right will not
        // null
        if (right != null)
            right.prev = left;

        return head;

    }
}
