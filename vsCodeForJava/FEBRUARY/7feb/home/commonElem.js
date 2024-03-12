//www.geeksforgeeks.org/problems/common-elements1132/1

// Dry Run:

// i = 0, j = 0, k = 0
// arr1[i] = 1, arr2[j] = 6, arr3[k] = 3 (minimum is 1, increment i)
// arr1[i] = 5, arr2[j] = 6, arr3[k] = 3 (minimum is 3, increment k)
// arr1[i] = 5, arr2[j] = 6, arr3[k] = 4 (minimum is 4, increment k)
// arr1[i] = 5, arr2[j] = 6, arr3[k] = 15 (minimum is 5, increment i, j, and k)
// arr1[i] = 10, arr2[j] = 7, arr3[k] = 15 (minimum is 7, increment j)
// arr1[i] = 10, arr2[j] = 20, arr3[k] = 15 (minimum is 10, increment i)
// arr1[i] = 20, arr2[j] = 20, arr3[k] = 15 (common element found, push 20 to res, update last to 20, increment i, j, and k)
// arr1[i] = 40, arr2[j] = 80, arr3[k] = 30 (minimum is 30, increment k)
// arr1[i] = 40, arr2[j] = 80, arr3[k] = 70 (minimum is 40, increment i)
// arr1[i] = 80, arr2[j] = 80, arr3[k] = 70 (common element found, push 80 to res, update last to 80, increment i, j, and k)
// arr1[i] = 80, arr2[j] = 100, arr3[k] = 70 (minimum is 70, increment k)
// arr1[i] = 80, arr2[j] = 100, arr3[k] = 80 (common element found, but equal to last, increment i, j, and k)
// arr1[i] = undefined (end of array arr1, loop terminates)
// Output: [20, 80]

function commonElem(arr1, arr2, arr3) {
  let res = [];
  let i = 0;
  let j = 0;
  let k = 0;

  let lastNum = Number.MAX_SAFE_INTEGER;
  while (i < arr1.length && j < arr2.length && k < arr3.length) {
    if (arr1[i] === arr2[j] && arr1[i] === arr3[k] && arr1[i] !== lastNum) {
      res.push(arr1[i]);
      lastNum = arr1[i];
      i++;
      j++;
      k++;
    } else if (Math.min(arr1[i], arr2[j], arr3[k]) === arr1[i]) {
      i++;
    } else if (Math.min(arr1[i], arr2[j], arr3[k]) === arr2[j]) {
      j++;
    } else {
      k++;
    }
  }

  return res;
}
console.log(
  commonElem(
    [1, 5, 10, 20, 40, 80, 90],
    [6, 7, 20, 80, 100, 90],
    [3, 4, 15, 20, 30, 70, 80, 120, 90]
  )
);

// function commonElem(arr1, arr2, arr3) {
//   arr1.sort((a, b) => a - b);
//   arr2.sort((a, b) => a - b);
//   arr3.sort((a, b) => a - b);

//   let res = [];
//   let i = 0;
//   let j = 0;
//   let k = 0;

//   while (i < arr1.length && j < arr2.length && k < arr3.length) {
//     if (arr1[i] === arr2[j] && arr1[i] === arr3[k]) {
//       res.push(arr1[i]);
//       i++;
//       j++;
//       k++;
//     } else if (arr1[i] < arr2[j]) {
//       i++;
//     } else if (arr2[j] < arr3[k]) {
//       j++;
//     } else {
//       k++;
//     }
//   }

//   return res;
// }

// console.log(
//   commonElem(
//     [1, 5, 10, 20, 40, 80, 90],
//     [6, 7, 20, 80, 100, 90],
//     [3, 4, 15, 20, 30, 70, 80, 120, 90]
//   )
// );
