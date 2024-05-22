// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/

var bstToGstHelper = function (node, sum) {
  if (node === null) return sum;

  sum = bstToGstHelper(node.right, sum);
  sum += node.val;
  node.val = sum;
  sum = bstToGstHelper(node.left, sum);

  return sum;
};

var bstToGst = function (root) {
  bstToGstHelper(root, 0);
  return root;
};
