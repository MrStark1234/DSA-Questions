// Link : https://leetcode.com/problems/n-queens/

import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<StringBuilder> board;

    boolean isSafe(int i, int j, int n) {
        // Check for the jth column
        for (int i2 = 0; i2 < i; ++i2)
            if (board.get(i2).charAt(j) == 'Q')
                return false;

        // Check while going up and right
        for (int i2 = i - 1, j2 = j + 1; i2 >= 0 && j2 < n; i2--, j2++) {
            if (board.get(i2).charAt(j2) == 'Q')
                return false;
        }

        // Check while going up and left
        for (int i2 = i - 1, j2 = j - 1; i2 >= 0 && j2 >= 0; i2--, j2--) {
            if (board.get(i2).charAt(j2) == 'Q')
                return false;
        }

        return true;
    }

    void exploreAllOptions(int i, int n, List<List<String>> validOptions) {
        if (i == n) {
            // Make a new board by converting the stringbuilders to strings
            List<String> compatibleBoard = new ArrayList<>();
            for (StringBuilder sb : board)
                compatibleBoard.add(sb.toString());

            validOptions.add(compatibleBoard);
            return;
        }

        // Try putting the queen on each cell
        // of the current row i.
        for (int j = 0; j < n; ++j) {
            if (isSafe(i, j, n)) {
                board.get(i).setCharAt(j, 'Q');
                exploreAllOptions(i + 1, n, validOptions);
                board.get(i).setCharAt(j, '.'); // Backtrack
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        StringBuilder nDots = new StringBuilder();
        for (int i = 0; i < n; ++i)
            nDots.append(".");

        // Put N dots in each row of the board.
        board = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            board.add(new StringBuilder(nDots));
        }

        List<List<String>> validOptions = new ArrayList<>();
        exploreAllOptions(0, n, validOptions);
        return validOptions;
    }
}
