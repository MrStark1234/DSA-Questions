/*
Q4 - Rotate List
Question Link - https://leetcode.com/problems/rotate-list/description/

Logic - 
1. Find the size of linkedlist, call it s
2. Check whether size 0 or 1 or k=0 if yes then return head
3. For k greater than size of LL use formula k =k%s. Because rotating the list k times is equivalent to not rotating the list
4. Iterate in LL upto s-k-1. We will reach the node where connections need to be changed
5. In LL with start(new head) connect the end to head of given LL
6. at last return start

Time Complexity - o(n)
Space Complexity - O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            RotateList head = null;
            RotateList tail = null;
            while (n-- > 0) {
                int x = sc.nextInt();
                if (head == null) {
                    head = tail = new RotateList(x);
                } else {
                    tail.next = new RotateList(x);
                    tail = tail.next;
                }
            }
            Solution obj = new Solution();
            RotateList ptr = obj.rotateRight(head, k);
            while (ptr != null) {
                System.out.print(ptr.val + " ");
                ptr = ptr.next;
            }
        }
    }
}

class Solution {
    public int size(RotateList head) {
        int s = 0;
        while (head != null) {
            s++;
            head = head.next;
        }
        return s;
    }

    public RotateList rotateRight(RotateList head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int s = size(head);
        k %= s;
        if (k == 0)
            return head;

        int go = s - k - 1;
        RotateList temp = head;
        for (int i = 0; i < go; i++) {
            temp = temp.next;
        }

        RotateList start = temp.next;
        temp.next = null;

        temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;

        return start;
    }
}

public class RotateList {
    int val;
    RotateList next;

    RotateList() {
    }

    RotateList(int val) {
        this.val = val;
    }

    RotateList(int val, RotateList next) {
        this.val = val;
        this.next = next;
    }
}
