import java.util.LinkedList;

class MyQueue {
    LinkedList<Integer> ll;

    public MyQueue() {
        ll = new LinkedList<>();
    }

    public void push_back(int x) {
        ll.addLast(x);
    }

    public void push_front(int x) {
        ll.addFirst(x);
    }

    public int pop_back() {
        return ll.poll();
    }

    public int pop_front() {
        return ll.pollFirst();
    }

    public int peek_back() {
        return ll.getLast();
    }

    public int peek_front() {
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
