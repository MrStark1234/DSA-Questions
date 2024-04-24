// Link : https://leetcode.com/problems/n-queens/

import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<StringBuilder> board;
    boolean[] col, tlTobr, blTotr;

    boolean isSafe(int i, int j, int n) {
        return col[j] == false && tlTobr[i - j + n - 1] == false && blTotr[i + j] == false;
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
                // Set all the relevant DS
                board.get(i).setCharAt(j, 'Q');
                col[j] = true;
                tlTobr[i - j + n - 1] = true;
                blTotr[i + j] = true;

                exploreAllOptions(i + 1, n, validOptions);

                // Reset all the relevant DS
                board.get(i).setCharAt(j, '.'); // Backtrack
                col[j] = false;
                tlTobr[i - j + n - 1] = false;
                blTotr[i + j] = false;
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

        col = new boolean[n];
        tlTobr = new boolean[2 * n];
        blTotr = new boolean[2 * n];

        List<List<String>> validOptions = new ArrayList<>();
        exploreAllOptions(0, n, validOptions);
        return validOptions;
    }
}
