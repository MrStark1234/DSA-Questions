// Link : https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}

// m is the given matrix and n is the order of matrix
class Solution {
    static void explorePaths(int[][] m, int i, int j, int n, StringBuilder curPath, ArrayList<String> validPaths) {
        if (Math.min(i, j) < 0 || Math.max(i, j) >= n || m[i][j] == 0)
            return;

        if (i == n - 1 && j == n - 1) {
            validPaths.add(curPath.toString());
            return;
        }

        // Before exploring, mark the current cell as blocked
        // so that you don't end up in an infinite loop
        m[i][j] = 0;

        // Down
        curPath.append("D");
        explorePaths(m, i + 1, j, n, curPath, validPaths);
        curPath.deleteCharAt(curPath.length() - 1);

        // Left
        curPath.append("L");
        explorePaths(m, i, j - 1, n, curPath, validPaths);
        curPath.deleteCharAt(curPath.length() - 1);

        // Right
        curPath.append("R");
        explorePaths(m, i, j + 1, n, curPath, validPaths);
        curPath.deleteCharAt(curPath.length() - 1);

        // Up
        curPath.append("U");
        explorePaths(m, i - 1, j, n, curPath, validPaths);
        curPath.deleteCharAt(curPath.length() - 1);

        // Set it back to unblocked.
        m[i][j] = 1;
    }

    public ArrayList<String> findPath(int[][] m, int n) {
        StringBuilder curPath = new StringBuilder();
        ArrayList<String> validPaths = new ArrayList<>();
        explorePaths(m, 0, 0, n, curPath, validPaths);
        return validPaths;
    }
}
