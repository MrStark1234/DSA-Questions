import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1, s2;

    private void transfer() {
        while (s1.size() > 0) {
            s2.push(s1.peek());
            s1.pop();
        }
    }

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.size() == 0)
            transfer();
        int frontElement = s2.peek();
        s2.pop();
        return frontElement;
    }

    public int peek() {
        if (s2.size() == 0)
            transfer();
        return s2.peek();
    }

    public boolean empty() {
        return s1.size() == 0 && s2.size() == 0;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}