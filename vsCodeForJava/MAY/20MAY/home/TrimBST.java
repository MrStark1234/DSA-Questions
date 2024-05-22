// Link : https://leetcode.com/problems/trim-a-binary-search-tree/

public class TrimBST {
    int val;
    TrimBST left;
    TrimBST right;
    public Integer data;

    TrimBST() {
    }

    TrimBST(int val) {
        this.val = val;
    }

    TrimBST(int val,
            TrimBST left,
            TrimBST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TrimBST trimBST(TrimBST root, int low, int high) {
        if (root == null)
            return null;

        if (root.val > high) // right will also be trimmed
            return trimBST(root.left, low, high);

        if (root.val < low) // left will also be trimmed
            return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}