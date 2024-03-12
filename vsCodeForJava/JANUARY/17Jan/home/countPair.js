// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/
// LeetCode:Count Pairs Whose Sum is Less than Target

var countPairs = function (nums, target) {
  let res = 0;
  let n = nums.length;
  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      if (nums.get(i) + nums.get(j) < target) {
        res++;
      }
    }
  }

  return res;
};
