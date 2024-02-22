//leetcode.com/problems/modify-the-matrix/description/

//Time Complexity = O(m*n)

https: var modifiedMatrix = function (matrix) {
  let ans = JSON.parse(JSON.stringify(matrix)); // Create a deep copy of the original matrix

  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[i].length; j++) {
      if (matrix[i][j] === -1) {
        let maxInColumn = -Infinity;
        // Find the maximum value in the current column
        for (let k = 0; k < matrix.length; k++) {
          maxInColumn = Math.max(maxInColumn, matrix[k][j]);
        }
        ans[i][j] = maxInColumn;
      }
    }
  }
  return ans;
};
console.log(
  modifiedMatrix([
    [1, 2, -1],
    [4, -1, 6],
    [7, 8, 9],
  ])
);
//[[1,2,9],[4,8,6],[7,8,9]]
