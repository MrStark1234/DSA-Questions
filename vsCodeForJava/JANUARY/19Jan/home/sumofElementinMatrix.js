// https://www.geeksforgeeks.org/problems/sum-of-elements-in-a-matrix2000/1
// GFG Sum of elements in a matrix

function sumOfMatrix(N, M, Grid) {
  let sum = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      sum += Grid[i][j];
    }
  }
  return sum;
}
console.log(
  sumOfMatrix(2, 3, [
    [1, 0, 1],
    [-8, 9, -1],
  ])
);
