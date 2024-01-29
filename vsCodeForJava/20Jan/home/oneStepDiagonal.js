//https://www.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1

// function matrixDiagonally(arr, n) {
//   const result = [];

//   for (let i = 0; i < n; i++) {
//     for (let j = 0; j <= i; j++) {
//       result.push(arr[j][i - j]);
//     }
//   }

//   for (let i = 1; i < n; i++) {
//     for (let j = i; j < n; j++) {
//       result.push(arr[j][n - j + i - 1]);
//     }
//   }

//   return result;
// }

// console.log(
//   matrixDiagonally(
//     [
//       [1, 2, 3],
//       [4, 5, 6],
//       [7, 8, 9],
//     ],
//     3
//   )
// );

function printDiagonal(matrix) {
  const N = matrix.length;
  let result = [];

  for (let i = 0; i < 2 * N - 1; i++) {
    if (i % 2 === 0) {
      for (let j = i; j >= 0; j--) {
        if (i - j < N && j < N) {
          result.push(matrix[j][i - j]);
        }
      }
    } else {
      for (let j = 0; j <= i; j++) {
        if (i - j < N && j < N) {
          result.push(matrix[j][i - j]);
        }
      }
    }
  }

  return result;
}

console.log(
  printDiagonal([
    [8, 10, 11],
    [9, 12, 15],
    [16, 18, 20],
  ])
);
