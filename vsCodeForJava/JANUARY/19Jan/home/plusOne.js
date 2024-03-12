// https://leetcode.com/problems/plus-one/description/
// LeetCode: Plus One

var plusOne = function (digits) {
  let n = digits.length;

  for (let i = n - 1; i >= 0; i--) {
    if (digits[i] < 9) {
      digits[i]++;
      return digits;
    } else {
      digits[i] = 0;
    }
  }
  let result = [1];
  for (let i = 0; i < n; i++) {
    result.push(0);
  }
  return result;
};
console.log(plusOne([9, 8, 7, 6]));
