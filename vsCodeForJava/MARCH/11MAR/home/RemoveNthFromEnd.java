/*
Q2 - Remove Nth Node From End of List
Question Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Logic - 
1. Calculate the total nodes in the list. 
If the total nodes in the list is N. We can traverse N-n nodes from the beginning and delete the node.
Two passes of the linked list is required for this approach. 
	i. first pass to calculate the number of nodes
	ii. second pass to reach the desired node and delete it
Time Complexity - O(n) - 2 passes
Space Complexity - O(1)

2. One pass Solution
Traverse a pointer n nodes from the head -> call it ptr1
Now, make another pointer ptr2, and point it to head of list.
Now move both the pointers simultaneously 1 node at a time till ptr2 reached the end.
At this point, ptr1 will be at the nth node from the end.
Time Complexity - O(n) - 1 pass
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int n = sc.nextInt();
            RemoveNthFromEnd head = null;
            RemoveNthFromEnd tail = null;
            while (N-- > 0) {
                int x = sc.nextInt();
                if (head == null) {
                    head = tail = new RemoveNthFromEnd(x);
                } else {
                    tail.next = new RemoveNthFromEnd(x);
                    tail = tail.next;
                }
            }
            Solution obj = new Solution();
            RemoveNthFromEnd ptr = obj.removeNthFromEnd(head, n);
            while (ptr != null) {
                System.out.print(ptr.val + " ");
                ptr = ptr.next;
            }
        }
    }
}

class Solution {
    public RemoveNthFromEnd removeNthFromEnd(RemoveNthFromEnd head, int n) {
        RemoveNthFromEnd dummy = new RemoveNthFromEnd(0);
        dummy.next = head;
        RemoveNthFromEnd first = dummy;
        RemoveNthFromEnd second = dummy;

        for (int i = 0; i <= n; ++i) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        RemoveNthFromEnd temp = second.next;
        second.next = second.next.next;

        return dummy.next;
    }
}

public class RemoveNthFromEnd {
    int val;
    RemoveNthFromEnd next;

    RemoveNthFromEnd() {
    }

    RemoveNthFromEnd(int val) {
        this.val = val;
    }

    RemoveNthFromEnd(int val, RemoveNthFromEnd next) {
        this.val = val;
        this.next = next;
    }
}
