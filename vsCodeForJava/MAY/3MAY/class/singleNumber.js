//https://leetcode.com/problems/single-number/

var singleNumber = function (nums) {
  let ans = 0;
  for (let num of nums) {
    ans ^= num;
  }
  return ans;
};
