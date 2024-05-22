// Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.Arrays;

public class constructBT {
    int val;
    constructBT left;
    constructBT right;

    constructBT() {
    }

    constructBT(int val) {
        this.val = val;
    }

    constructBT(int val, constructBT left, constructBT right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public constructBT buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        int rootVal = preorder[0];
        constructBT rootNode = new constructBT(rootVal);

        // Find where the root is, in the inorder array.
        int rootId = -1;
        for (int i = 0; i < inorder.length; ++i)
            if (inorder[i] == rootVal) {
                rootId = i;
                break;
            }

        // Let's try to get the inorder for left & right rubtrees.
        int[] leftInOrder = Arrays.copyOf(inorder, rootId);// inorder[0.....rootId - 1]
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootId + 1, inorder.length); // inorder[rootId + 1....]

        // Let's try to get the preorder for left & right rubtrees.
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length + 1); // preorder[1.....leftInorder.length]
        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftInOrder.length + 1, preorder.length); // preorder[leftInOrder.length
                                                                                                     // + 1 .... ]

        rootNode.left = buildTree(leftPreOrder, leftInOrder);
        rootNode.right = buildTree(rightPreOrder, rightInOrder);

        return rootNode;
    }
}
