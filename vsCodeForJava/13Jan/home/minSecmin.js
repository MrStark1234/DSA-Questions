function minAnd2ndMin(arr, n) {
  //code here
  let min = arr[0];
  let min2 = Infinity;
  for (let i = 1; i < n; i++) {
    if (arr[i] < min) {
      min2 = min;
      min = arr[i];
    } else if (arr[i] < min2 && arr[i] != min) {
      min2 = arr[i];
    }
  }
  return { min, min2 };
}
console.log(minAnd2ndMin([2, 2, 2, 2, 6], 5));
