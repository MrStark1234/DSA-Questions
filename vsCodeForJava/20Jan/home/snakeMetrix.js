function snakePattern(matrix) {
  let result = [];

  if (!matrix || matrix.length === 0 || matrix[0].length === 0) {
    return result;
  }

  const rows = matrix.length;
  const cols = matrix[0].length;

  for (let i = 0; i < rows; i++) {
    // For even rows, iterate left to right
    if (i % 2 === 0) {
      for (let j = 0; j < cols; j++) {
        result.push(matrix[i][j]);
      }
    } else {
      // For odd rows, iterate right to left
      for (let j = cols - 1; j >= 0; j--) {
        result.push(matrix[i][j]);
      }
    }
  }

  return result;
}
