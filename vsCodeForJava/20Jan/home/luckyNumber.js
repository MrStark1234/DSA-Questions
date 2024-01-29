//https://leetcode.com/problems/lucky-numbers-in-a-matrix/

var luckyNumbers = function (matrix) {
  let ans = [];
  for (let i = 0; i < matrix.length; i++) {
    let small = Math.min(...matrix[i]);
    let k = matrix[i].indexOf(small);

    let big = small;
    for (let j = 0; j < matrix.length; j++) {
      big = Math.max(big, matrix[j][k]);
    }

    if (small === big) {
      ans.push(small);
    }
  }
  return ans;
};
console.log(
  luckyNumbers([
    [3, 7, 8],
    [9, 11, 13],
    [15, 16, 17],
  ])
);
