// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.LinkedList;

class MyQueue {
    LinkedList<Integer> ll;

    public MyQueue() {
        ll = new LinkedList<>();
    }

    public void push(int x) {
        ll.addLast(x);
    }

    public int pop() {
        return ll.pollFirst();
    }

    public int peek() {
        return ll.getFirst();
    }

    public boolean empty() {
        return ll.size() == 0;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}
