/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversalHelper = function (root, ans) {
  if (root == null) return;
  postorderTraversalHelper(root.left, ans);
  postorderTraversalHelper(root.right, ans);
  ans.push(root.val);
};
var postorderTraversal = function (root) {
  let ans = [];
  postorderTraversalHelper(root, ans);
  return ans;
};
