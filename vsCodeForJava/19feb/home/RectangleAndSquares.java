/*
Rectangles and Squares
Question Link-https://practice.geeksforgeeks.org/contest/job-a-thon-11-hiring-challenge/problems [Rectangles and Squares]


In this we have a rectangular grid of dimension a×b .
We have to find minimum number of square tiles required to cover whole grid. 
The optimal option is to choose biggest square which can fit in a×b.
Let suppose a<b then we can choose (a×a)square tiles.
Now we left with (a×(b-a))dimension , so we again call the function for (a,(b-a));
*/

//Brute Force Solution-
class RectangleAndSquares {
    public int solve(int a, int b) {
        if (a == 1)
            return b;
        if (b == 1)
            return a;
        if (a == b)
            return 1;
        int ans;
        if (a < b) {
            ans = solve(a, b - a) + 1;
        } else {
            ans = solve(a - b, b) + 1;
        }
        return ans;
    }

    public int minimumMoves(int A, int B) {
        return solve(A, B);
    }
}

// Now you can optimise it to same as 4 question
class Solution {
    public int solve(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        if (a == 1)
            return b;
        if (b == 1)
            return a;
        if (a == b)
            return 1;
        int ans;
        if (a < b) {
            ans = solve(a, b % a) + (b / a);
        } else {
            ans = solve(a % b, b) + (a / b);
        }
        return ans;
    }

    public int minimumMoves(int A, int B) {
        return solve(A, B);
    }
}
