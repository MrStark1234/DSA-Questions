//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

// function missingNumber(arr) {
//   for (let i = 0; i < arr.length; i++) {
//     let found = false;
//     for (val of arr) {
//       if (val === i) {
//         found = true;
//         break;
//       }
//     }
//     if (!found) {
//       return i;
//     }
//   }
//   return 0;
// }

// console.log(missingNumber([0, 1, 5, 6, 3, 4]));

// function findMissingSum(arr) {
//   let N = arr.length;
//   let expected_sum = (N * (N + 1)) / 2;
//   let actual_sum = 0;

//   for (let val of arr) {
//     actual_sum += val;
//   }
//   return expected_sum - actual_sum;
// }

function findMissingNumbers(nums) {
  const n = nums.length;
  const numSet = new Set(nums);
  const missingNumbers = [];

  for (let i = 1; i <= n; i++) {
    if (!numSet.has(i)) {
      missingNumbers.push(i);
    }
  }

  return missingNumbers;
}
console.log(findMissingSum([0, 1, 5, 2, 3, 4]));
