// Link : https://www.geeksforgeeks.org/problems/tower-of-hanoi/1

import java.util.*;

class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();// total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;

            // taking input N
            N = sc.nextInt();

            // calling toh() method
            System.out.println(obj.toh(N, 1, 3, 2));
        }
        sc.close();
    }
}

class Hanoi {
    public long toh(int N, int from, int to, int aux) {
        if (N == 0) // base case
            return 0;

        long moves = 0;

        // Transfer N - 1 discs from 'from' to 'aux' by taking
        // the help of 'to'
        moves += toh(N - 1, from, aux, to);

        // Now, move the last Nth disc from 'from' to 'to'.
        moves += 1;
        System.out.println("move disk " + N + " from rod " + from +
                " to rod " + to);

        // Now, put back all those N - 1 discs from 'aux' to 'to' by taking
        // the help of 'from'.
        moves += toh(N - 1, aux, to, from);
        return moves;
    }
}
