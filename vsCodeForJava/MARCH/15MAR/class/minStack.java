import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Link : https://leetcode.com/problems/min-stack/

class MinStack {
    Stack<Integer> actual;
    Stack<Integer> preMin;

    public MinStack() {
        actual = new Stack<>();
        preMin = new Stack<>();
    }

    public void push(int val) {
        actual.push(val);
        if (!preMin.empty())
            preMin.push(Math.min(val, preMin.peek()));
        else
            preMin.push(val);
    }

    public void pop() {
        actual.pop();
        preMin.pop();
    }

    public int top() {
        return actual.peek();
    }

    public int getMin() {
        return preMin.peek();
    }
}
