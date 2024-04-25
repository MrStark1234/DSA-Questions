// https://leetcode.com/problems/word-search/description/

// The problem can be solved by traversing the grid and 
// performing a depth-first search (DFS) for each possible 
// starting position. At each cell, we check if the current 
// character matches the corresponding character of the word. 
// If it does, we explore all four directions (up, down, left, 
// right) recursively until we find the complete word or exhaust 
// all possibilities.

public class wordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result)
                        return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
                backtrack(board, word, visited, i - 1, j, index + 1) ||
                backtrack(board, word, visited, i, j + 1, index + 1) ||
                backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
