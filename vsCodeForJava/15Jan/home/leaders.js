// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
// GFG : Leaders in an array

function leaders(arr) {
  let ans = [];
  let currentLeader = 0;
  for (let i = arr.length - 1; i >= 0; i--) {
    if (arr[i] >= currentLeader) {
      currentLeader = arr[i];
      ans.push(currentLeader);
    }
  }
  return ans;
}
console.log(leaders([16, 17, 4, 3, 5, 2]));
