// https://www.geeksforgeeks.org/problems/sums-of-i-th-row-and-i-th-column3054/1
// GFG: Sums of i-th row and i-th column

function sumOfRowCol(N, M, A) {
  let valid = Math.min(N, M);

  for (let i = 0; i < valid; i++) {
    let rowSum = 0;
    for (let j = 0; j < N; j++) {
      rowSum += A[i][j];
    }

    let colSum = 0;
    for (let j = 0; j < M; j++) {
      colSum += A[j][i];
    }

    if (rowSum !== colSum) {
      return 0;
    }
  }
  return 1;
}
console.log(
  sumOfRowCol(2, 3, [
    [3, 2],
    [2, 3],
    [0, 1],
  ])
);
