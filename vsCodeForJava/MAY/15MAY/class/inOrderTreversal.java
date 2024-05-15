
//   Definition for a binary tree node.

import java.util.ArrayList;
import java.util.List;

public class inOrderTreversal {
    int val;
    inOrderTreversal left;
    inOrderTreversal right;

    inOrderTreversal() {
    }

    inOrderTreversal(int val) {
        this.val = val;
    }

    inOrderTreversal(int val, inOrderTreversal left, inOrderTreversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    void inorderTraversalHelper(inOrderTreversal root, List<Integer> ans) {
        if (root == null)
            return;
        inorderTraversalHelper(root.left, ans);
        ans.add(root.val);
        inorderTraversalHelper(root.right, ans);
    }

    public List<Integer> inorderTraversal(inOrderTreversal root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalHelper(root, ans);
        return ans;
    }
}