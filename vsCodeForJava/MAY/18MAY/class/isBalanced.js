//https://leetcode.com/problems/balanced-binary-tree/description/

var height = function (root) {
  return root === null
    ? 0
    : Math.max(height(root.left), height(root.right)) + 1;
};
var isBalanced = function (root) {
  return root === null
    ? true
    : Math.abs(height(root.left) - height(root.right)) < 2 &&
        isBalanced(root.left) &&
        isBalanced(root.right);
};
