//https://leetcode.com/problems/merge-two-binary-trees/

public class mergeTree {
    int val;
    mergeTree left;
    mergeTree right;

    mergeTree() {
    }

    mergeTree(int val) {
        this.val = val;
    }

    mergeTree(int val,
            mergeTree left,
            mergeTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public mergeTree mergeTrees(mergeTree t1, mergeTree t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        mergeTree node = new mergeTree(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}