/*
Q1 - Palindrome Linked List
Question Link - https://leetcode.com/problems/palindrome-linked-list/description/

Logic - A lot of possible solutions exist for this problem

1. Store the linked list in an array and check if the array is palindrome or not
Time Complexity - O(n)
Space Complexiy - O(n)

2. Reverse the Linked List and compare with original linked list
Time Complexity - O(n)
Space Complexity - O(n)

3. Reverse half linked list
Instead of reversing the whole linked list, we can reverse half of the linked list.
Now, we don't need to store the original linked list and we can traverse
the modified linked list using two pointers.
Code for this approach is given below
Time Complexity - O(n)
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            PalindromeLL head = null;
            PalindromeLL tail = null;
            while (n-- > 0) {
                int x = sc.nextInt();
                if (head == null) {
                    head = tail = new PalindromeLL(x);
                } else {
                    tail.next = new PalindromeLL(x);
                    tail = tail.next;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.isPalindrome(head));
        }
    }
}

class Solution {
    public boolean isPalindrome(PalindromeLL head) {
        PalindromeLL slow = head;
        PalindromeLL fast = head;
        PalindromeLL next = null;
        PalindromeLL prev = new PalindromeLL();

        while (fast != null && fast.next != null) {
            // for finding middle
            slow = slow.next;
            fast = fast.next.next;

            // reversing first half
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        // for edge cases
        if (fast != null)
            slow = slow.next;
        head = prev;

        // comparing first half to second one
        while (slow != null) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}

public class PalindromeLL {
    int val;
    PalindromeLL next;

    PalindromeLL() {
    }

    PalindromeLL(int val) {
        this.val = val;
    }

    PalindromeLL(int val, PalindromeLL next) {
        this.val = val;
        this.next = next;
    }
}
