// Link : https://leetcode.com/problems/search-in-a-binary-search-tree/

// Definition for a binary tree node.
public class searchInBST {
    int val;
    searchInBST left;
    searchInBST right;

    searchInBST() {
    }

    searchInBST(int val) {
        this.val = val;
    }

    searchInBST(int val, searchInBST left, searchInBST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public searchInBST searchBST(searchInBST root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        searchInBST leftNode = searchBST(root.left, val);
        searchInBST rightNode = searchBST(root.right, val);

        return leftNode == null ? rightNode : leftNode;
    }
}
