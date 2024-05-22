// Link : https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {
    Node node;
    int col;

    Pair(Node a, int b) {
        node = a;
        col = b;
    }
}

class Solution {
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, Integer> colToVal = new TreeMap<>();

        // We'll do level order, and also store column number
        // for each node, and then save the first node we get
        // for each column in the colToVal Map.
        Queue<Pair> q = new LinkedList<>(); // [node, column number]
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Node curNode = q.peek().node;
            int col = q.peek().col;
            q.remove();

            // If it's the first node of this column,
            // insert it to our map
            if (!colToVal.containsKey(col))
                colToVal.put(col, curNode.data);

            if (curNode.left != null)
                q.add(new Pair(curNode.left, col - 1));

            if (curNode.right != null)
                q.add(new Pair(curNode.right, col + 1));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> kv : colToVal.entrySet())
            ans.add(kv.getValue());

        return ans;
    }
}