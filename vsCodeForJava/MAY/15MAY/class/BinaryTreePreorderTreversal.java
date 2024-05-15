import java.util.ArrayList;
import java.util.List;

//  Definition for a binary tree node.
public class BinaryTreePreorderTreversal {
    int val;
    BinaryTreePreorderTreversal left;
    BinaryTreePreorderTreversal right;

    BinaryTreePreorderTreversal() {
    }

    BinaryTreePreorderTreversal(int val) {
        this.val = val;
    }

    BinaryTreePreorderTreversal(int val, BinaryTreePreorderTreversal left, BinaryTreePreorderTreversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    void preorderTraversalHelper(BinaryTreePreorderTreversal root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        preorderTraversalHelper(root.left, ans);
        preorderTraversalHelper(root.right, ans);
    }

    public List<Integer> preorderTraversal(BinaryTreePreorderTreversal root) {
        List<Integer> ans = new ArrayList<>(); // Initialize the list
        preorderTraversalHelper(root, ans);
        return ans;
    }
}
