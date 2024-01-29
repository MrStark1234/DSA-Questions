// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
// Leetcode: Replace Elements with Greatest Element on Right Side

/*
    Iterate from the right to the left,
    We initilize max_right = -1, where max_right represent the max on the right.
    Each round, we set arr[i] = max_right, where max_right is maximum element on the right.
    Also we update max_right = max(max_right, arr[i]).
*/

var replaceElements = function (arr) {
  let n = arr.length;
  let ans = [];
  let maxRight = -1;

  for (let i = n - 1; i >= 0; i--) {
    ans[i] = maxRight;
    if (maxRight < arr[i]) {
      maxRight = arr[i];
    }
  }

  return ans;
};
