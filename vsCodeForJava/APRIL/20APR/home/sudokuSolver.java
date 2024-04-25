// https://leetcode.com/problems/sudoku-solver/description/

// The given code is an implementation of the backtracking 
// algorithm to solve a Sudoku puzzle. The Sudoku puzzle is 
// a grid of 9x9 cells, divided into 3x3 subgrids (blocks). 
// The goal is to fill in the grid with digits from 1 to 9 
// such that every row, every column, and every 3x3 subgrid 
// contains all of the digits from 1 to 9 without repetition.

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    return false; // no valid option found
                }
            }
        }
        return true; // board is solved
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
