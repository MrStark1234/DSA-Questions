// https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/
// LeetCode: Special Positions in a Binary Matrix

var numSpecial = function (mat) {
  let m = mat.length;
  let n = mat[0].length;
  let row = [];
  let col = [];

  for (let i = 0; i < m; i++) row[i] = 0;
  for (let j = 0; j < n; j++) col[j] = 0;

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (mat[i][j] == 1) {
        row[i]++;
        col[j]++;
      }
    }
  }

  let ans = 0;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
        ans++;
      }
    }
  }
  return ans;
};
console.log(
  numSpecial([
    [0, 0],
    [0, 0],
    [1, 0],
  ])
);
