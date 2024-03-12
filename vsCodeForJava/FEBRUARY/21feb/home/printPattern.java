// Print Pattern
// https://www.geeksforgeeks.org/problems/print-pattern3549/1

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pattern(int N) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();

        rec(N, arr);

        return arr;

    }

    public void rec(int N, ArrayList<Integer> arr) {
        // base case
        if (N <= 0) {
            arr.add(N);
            return;
        }
        arr.add(N);
        rec(N - 5, arr);
        arr.add(N);
    }
}