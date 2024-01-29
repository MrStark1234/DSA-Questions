//https://leetcode.com/problems/matrix-diagonal-sum/

var diagonalSum = function (mat, n) {
  let sum = 0;
  for (let i = 0; i < n; i++) {
    sum += mat[i][i];
    if (i !== n - i - 1) {
      sum += mat[i][n - i - 1];
    }
  }
  return sum;
};
console.log(diagonalSum([[5]], 1));
