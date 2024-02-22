/*
Q3 - Minimum Average Difference
Question Link - https://leetcode.com/problems/minimum-average-difference/description/
Time Complexity - O(n+n) ~ O(n)
Space Complexity - O(n+1) ~ O(n) 
*/

var minimumAverageDifference = function (nums) {
  const n = nums.length;
  const pre = new Array(n + 1).fill(0);

  for (let i = 0; i < n; i++) {
    pre[i + 1] = pre[i] + nums[i];
  }

  let ansIdx = -1;
  let minDiff = Number.MAX_SAFE_INTEGER;

  for (let i = 0; i < n; i++) {
    let l = Math.floor(pre[i + 1] / (i + 1));
    let r = 0;

    if (i < n - 1) {
      r = Math.floor((pre[n] - pre[i + 1]) / (n - i - 1));
    }

    let currDiff = Math.abs(l - r);

    if (currDiff < minDiff) {
      minDiff = currDiff;
      ansIdx = i;
    }
  }

  return ansIdx;
};
