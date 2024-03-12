// https://www.geeksforgeeks.org/problems/count-sorted-rows2702/1
// Count Sorted Rows

function sortedCount(N, M, Mat) {
  function isIncreasing(v) {
    for (let i = 1; i < v.length; i++) {
      if (v[i] <= v[i - 1]) {
        return false;
      }
    }
    return true;
  }
  function isDecreasing(v) {
    for (let i = 1; i < v.length; i++) {
      if (v[i] >= v[i - 1]) {
        return false;
      }
    }
    return true;
  }
  let ans = 0;
  for (let i = 0; i < N; i++) {
    if (isIncreasing(Mat[i]) || isDecreasing(Mat[i])) {
      ans++;
    }
  }
  return ans;
}
console.log(
  sortedCount(3, 3, [
    [1, 2, 3],
    [6, 5, 4],
    [7, 9, 8],
  ])
);
