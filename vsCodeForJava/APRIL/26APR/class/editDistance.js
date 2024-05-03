// Link : https://leetcode.com/problems/longest-increasing-subsequence/
// Time : O(N^2)

var minDistanceHelper = function (w1, w2, i, j, dp) {
  if (i == w1.length && j == w2.length) return 0;
  if (i == w1.length) return w2.length - j;
  if (j == w2.length) return w1.length - i;

  if (dp[i][j] !== -1) return dp[i][j];
  if (w1[i] === w2[j]) {
    return (dp[i][j] = minDistanceHelper(w1, w2, i + 1, j + 1, dp));
  } else {
    //For Insert
    let op1 = 1 + minDistanceHelper(w1, w2, i, j + 1, dp);
    //For Deletion
    let op2 = 1 + minDistanceHelper(w1, w2, i + 1, j, dp);
    //For Updation
    let op3 = 1 + minDistanceHelper(w1, w2, i + 1, j + 1, dp);
    return (dp[i][j] = Math.min(op1, op2, op3));
  }
};
var minDistance = function (word1, word2) {
  let dp = Array(word1.length + 1)
    .fill(null)
    .map(() => Array(word2.length + 1).fill(-1));

  return minDistanceHelper(word1, word2, 0, 0, dp);
};
