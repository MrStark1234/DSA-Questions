/*
Q3 - Add Two Numbers
Question Link - https://leetcode.com/problems/add-two-numbers/description/

Logic - 
We can move digit by digit as we do in elementary addition.
And since the lists are already in reverse order we can just start from the head
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n1 = sc.nextInt();
            AddTwoNum l1 = null;
            AddTwoNum t1 = null;
            while (n1-- > 0) {
                int x = sc.nextInt();
                if (l1 == null) {
                    l1 = t1 = new AddTwoNum(x);
                } else {
                    t1.next = new AddTwoNum(x);
                    t1 = t1.next;
                }
            }
            int n2 = sc.nextInt();
            AddTwoNum l2 = null;
            AddTwoNum t2 = null;
            while (n2-- > 0) {
                int x = sc.nextInt();
                if (l2 == null) {
                    l2 = t2 = new AddTwoNum(x);
                } else {
                    t2.next = new AddTwoNum(x);
                    t2 = t2.next;
                }
            }
            Solution obj = new Solution();
            AddTwoNum ptr = obj.addTwoNumbers(l1, l2);
            while (ptr != null) {
                System.out.print(ptr.val + " ");
                ptr = ptr.next;
            }
        }
    }
}

class Solution {
    public AddTwoNum addTwoNumbers(AddTwoNum l1, AddTwoNum l2) {
        AddTwoNum dummyHead = new AddTwoNum(0);
        AddTwoNum tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            // conditional statement checks if current node is present
            // if not then add 0 to current

            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // adding two digits
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;

            // carry is generated
            carry = sum / 10;

            // making new for the current digit
            AddTwoNum newNode = new AddTwoNum(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        AddTwoNum result = dummyHead.next;
        return result;
    }
}

public class AddTwoNum {
    int val;
    AddTwoNum next;

    AddTwoNum() {
    }

    AddTwoNum(int val) {
        this.val = val;
    }

    AddTwoNum(int val, AddTwoNum next) {
        this.val = val;
        this.next = next;
    }
}
