// https://www.geeksforgeeks.org/problems/queue-reversal/1

import java.util.Queue;
import java.util.Stack;

class GfG {
    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        while (!q.isEmpty()) {
            int element = q.poll();
            st.push(element);
        }

        while (!st.isEmpty()) {
            int top = st.pop();
            q.add(top);
        }

        return q;
    }
}
