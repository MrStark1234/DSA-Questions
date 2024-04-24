var robberHelper = function (nums, i, dp) {
  if (i >= nums.length) return 0;
  if (dp[i] !== -1) return dp[i];

  let opt1 = 0;
  let opt2 = 0;
  opt1 += nums[i];
  opt1 += robberHelper(nums, i + 2, dp);
  opt2 += 0;
  opt2 += robberHelper(nums, i + 1, dp);
  return (dp[i] = Math.max(opt1, opt2));
};
var rob = function (nums) {
  let dp = Array(nums.length + 1).fill(-1);
  return robberHelper(nums, 0, dp);
};
