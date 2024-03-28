import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Compute {

    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        ArrayList<Long> ans = new ArrayList<>();
        Queue<Long> neg = new LinkedList<>();
        int j = 0;

        // Adding negative numbers in a queue for the first window
        for (j = 0; j < K; j++) {
            if (A[j] < 0)
                neg.offer(A[j]);
        }

        // For the first window, if there is no negative number, store 0 as answer;
        // otherwise
        // store the first negative number as answer, which is queue's first element
        if (!neg.isEmpty())
            ans.add(neg.peek());
        else
            ans.add(0L);

        // Now checking for other possible windows
        for (j = K; j < N; j++) {
            // As we slide the window, we have to make sure that if the previous first
            // number is
            // negative, then remove it from the queue
            if (A[j - K] < 0) {
                neg.poll();
            }

            // If new number occurring in a window is negative, then add it to the queue
            if (A[j] < 0)
                neg.offer(A[j]);

            // Store answer for the current window
            if (!neg.isEmpty())
                ans.add(neg.peek());
            else
                ans.add(0L);
        }

        // Convert list to array
        long[] result = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
