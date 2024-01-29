// https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
// GFG: Row with max 1s

function rowWithMax1s(arr, n, m) {
  let max = 0;
  let index = -1;

  for (let i = 0; i < n; i++) {
    let count = 0;
    for (let j = 0; j < m; j++) {
      if (arr[i][j] == 1) {
        count++;
      }
    }
    if (count > max) {
      max = count;
      index = i;
    }
  }
  return index;
}
console.log(
  rowWithMax1s(
    [
      [1, 1, 1, 1],
      [0, 1, 1, 1],
      [0, 0, 1, 1],
      [0, 0, 0, 0],
    ],
    4,
    4
  )
);
