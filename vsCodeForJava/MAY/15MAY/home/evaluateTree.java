//https://leetcode.com/problems/evaluate-boolean-binary-tree/

public class evaluateTree {
    int val;
    evaluateTree left;
    evaluateTree right;

    evaluateTree() {
    }

    evaluateTree(int val) {
        this.val = val;
    }

    evaluateTree(int val,
            evaluateTree left,
            evaluateTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean evaluateTree(evaluateTree root) {
        if (root.val < 2) {
            return root.val != 0;
        } else if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
