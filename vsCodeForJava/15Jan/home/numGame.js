// https://leetcode.com/problems/minimum-number-game/description/
// LEETCODE : MINIMUM NUMBER GAME

var numberGame = function (nums) {
  nums.sort((a, b) => a - b);
  for (let i = 0; i < nums.length; i += 2) {
    let temp = nums[i];
    nums[i] = nums[i + 1];
    nums[i + 1] = temp;
  }
  return nums;
};
console.log(numberGame([17, 2, 4, 11, 14, 18]));
