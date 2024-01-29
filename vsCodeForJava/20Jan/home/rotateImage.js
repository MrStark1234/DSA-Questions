//https://leetcode.com/problems/rotate-image/submissions/1154690841/

var rotate = function (matrix) {
  const n = matrix.length;

  // Transpose the matrix
  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++) {
      // Swap matrix[i][j] with matrix[j][i]
      const temp = matrix[i][j];
      matrix[i][j] = matrix[j][i];
      matrix[j][i] = temp;
    }
  }

  // Reverse each row
  for (let i = 0; i < n; i++) {
    console.log(matrix[i].reverse());
  }
};
console.log(
  rotate([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
  ])
);
