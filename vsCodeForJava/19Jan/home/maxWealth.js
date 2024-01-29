// https://leetcode.com/problems/richest-customer-wealth/description/
// LeetCode: Richest Customer Wealth

var maximumWealth = function (accounts) {
  var maxWealth = 0;
  for (let i = 0; i < accounts.length; i++) {
    let totalWealth = 0;
    for (let j = 0; j < accounts[i].length; j++) totalWealth += accounts[i][j];

    if (totalWealth > maxWealth) {
      maxWealth = totalWealth;
    }
  }

  return maxWealth;
};
console.log(
  maximumWealth([
    [1, 2, 3],
    [3, 2, 1],
  ])
);
