public class buildTrees {
    int val;
    buildTrees left;
    buildTrees right;
    public Integer data;

    buildTrees() {
    }

    buildTrees(int val) {
        this.val = val;
    }

    buildTrees(int val,
            buildTrees left,
            buildTrees right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public buildTrees buildTree(int[] inorder, int[] postorder) {
        // Call the recursive function with full arrays and return the result
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private buildTrees buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // Base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Find the root node from the last element of postorder traversal
        int rootVal = postorder[postEnd];
        buildTrees root = new buildTrees(rootVal);

        // Find the index of the root node in inorder traversal
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // Recursively build the left and right subtrees
        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;
        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

        return root;
    }
}

/*
 * inorder = [4 2 5 1 6 3 7]
 * postorder = [4 5 2 6 7 3 1]
 * 
 * So root would be 1 here and Left array which lay left of 1 is [4 2 5] and
 * Right of 1 is [6 3 7]
 * so left_inorder_array = [4 2 5] and right_inorder_arry = [6 3 7]
 * 
 * using 6 [ which is just rigth of 1] we are going to devide Postorder_array
 * into two part
 * [4 5 2] and [6 7 3]
 * 
 * 
 * 1st Phase=>
 * 1
 * 
 * / \
 * 
 * [4 2 5] [6 3 7] <= inorder array
 * [4 5 2] [6 7 3] <= postorder array
 * 
 * Now we have new freash problem like need to make tree by using inorder = [4 2
 * 5] && postorder = [4 5 2] for left subtree
 * AND inorder = [6 3 7] && postorder = [6 7 3] for right subtree
 ** now same process we need to do again and again until One Of the array dose
 * not got empty
 * Rest of the Process show in a diagram Form :)
 * 
 * 2nd Phase =>
 * 1
 * 
 * / \
 * 2 3
 * [4] [5] [6] [7] <= inorder array
 * [4] [5] [6] [7] <= postorder array
 * 
 * 
 * 3rd Phase =>
 * 1
 * 
 * / \
 * 2 3
 * 
 * / \ / \ <==== Answer
 * 
 * 4 5 6 7
 * 
 */
