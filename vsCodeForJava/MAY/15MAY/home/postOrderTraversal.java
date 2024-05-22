//https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class postOrderTraversal {
    int val;
    postOrderTraversal left;
    postOrderTraversal right;

    postOrderTraversal() {
    }

    postOrderTraversal(int val) {
        this.val = val;
    }

    postOrderTraversal(int val, postOrderTraversal left, postOrderTraversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> postorderTraversal(postOrderTraversal root) {
        List<Integer> sol = new ArrayList<>();
        postorder(root, sol);
        return sol;
    }

    void postorder(postOrderTraversal root, List<Integer> sol) {
        if (root == null)
            return;
        postorder(root.left, sol);
        postorder(root.right, sol);
        sol.add(root.val);
    }
}