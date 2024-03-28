// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.ArrayList;

class MyQueue {
    private ArrayList<Integer> arr;
    private int front;

    public MyQueue() {
        arr = new ArrayList<>();
        front = 0;
    }

    public void push(int x) {
        arr.add(x);
    }

    public int pop() {
        int frontElement = arr.get(front);
        front += 1;
        return frontElement;
    }

    public int peek() {
        return arr.get(front);
    }

    // size = arr.size() - front;
    public boolean empty() {
        return front == arr.size();
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}