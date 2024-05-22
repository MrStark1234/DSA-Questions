//https://leetcode.com/problems/insert-into-a-binary-search-tree/description/

var insertIntoBST = function (root, val) {
  if (root == null) {
    root = new TreeNode(val);
    return root;
  }
  if (root.val > val) {
    root.left = insertIntoBST(root.left, val);
  } else {
    root.right = insertIntoBST(root.right, val);
  }
  return root;
};
