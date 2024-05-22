//https://leetcode.com/problems/validate-binary-search-tree/description/

var inorderTraversal = function (node, values) {
  if (node === null) return;

  inorderTraversal(node.left, values);
  values.push(node.val);
  inorderTraversal(node.right, values);
};
var isValidBST = function (root) {
  const values = [];
  inorderTraversal(root, values);
  for (let i = 1; i < values.length; i++) {
    if (values[i] <= values[i - 1]) {
      return false;
    }
  }

  return true;
};
