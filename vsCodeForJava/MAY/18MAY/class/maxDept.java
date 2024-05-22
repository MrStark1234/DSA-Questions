// Link : https://leetcode.com/problems/maximum-depth-of-binary-tree/

//  Definition for a binary tree node.
public class maxDept {
    int val;
    maxDept left;
    maxDept right;

    maxDept() {
    }

    maxDept(int val) {
        this.val = val;
    }

    maxDept(int val, maxDept left, maxDept right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(maxDept root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}