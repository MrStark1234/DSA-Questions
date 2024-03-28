// https://leetcode.com/problems/number-of-recent-calls/description/

// if the queue is not empty , pop the elements
// which are lesser than t-3000
// Push the current element into the queue
// Return queue size

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);

        while (!q.isEmpty() && q.peek() < t - 3000) {
            q.poll();
        }

        return q.size();
    }
}
