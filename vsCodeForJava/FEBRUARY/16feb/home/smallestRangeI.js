//leetcode.com/problems/smallest-range-i/description/

//Time Complexity = O(m*n)

https: var smallestRangeI = function (nums, k) {
  const minVal = Math.min(...nums);
  const maxVal = Math.max(...nums);

  const currentScore = maxVal - minVal;

  // Calculate the maximum reduction we can achieve using k
  const maxReduction = 2 * k;

  // If the current score is less than or equal to the maximum reduction possible,
  // then we can reduce the score to 0 by subtracting the maximum reduction from it
  if (currentScore <= maxReduction) {
    return 0;
  }

  // If the current score is greater than the maximum reduction possible and it's even,
  // we can achieve the minimum score by subtracting the maximum reduction from it
  if (currentScore > maxReduction && currentScore % 2 === 0) {
    return currentScore - maxReduction;
  }

  // If the current score is greater than the maximum reduction possible and it's odd,
  // we can achieve the minimum score by subtracting the maximum reduction minus 1 from it
  return currentScore - maxReduction + 1;
};

console.log(smallestRangeI([0, 10], 2));
//Output: 6
//Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
