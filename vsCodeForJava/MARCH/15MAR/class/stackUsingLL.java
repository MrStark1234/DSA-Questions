/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/*
    Link : https://leetcode.com/problems/implement-stack-using-queues/
    Although they've asked to implement using queues, but we can still
    use the problem to check our solution.

    In this, we'll also see how to use in-built Linked List
    from java.util package.
*/

import java.util.*;

class MyStack {
    private LinkedList<Integer> ll;

    public MyStack() {
        ll = new LinkedList<>();
    }

    public void push(int x) {
        ll.addFirst(x);
    }

    public int pop() {
        int ans = ll.pollFirst(); // Deletes the first and returns it.
        return ans;
    }

    public int top() {
        return ll.getFirst();
    }

    public boolean empty() {
        return (int) ll.size() == 0;
    }

    public void clear() {
        ll.clear();
    }
}

class Main {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(5);
        s.push(4);
        s.push(3);
        System.out.println(s.top());
    }
}
