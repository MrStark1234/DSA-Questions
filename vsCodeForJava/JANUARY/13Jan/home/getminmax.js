function getMinMax(arr, n) {
  //code here
  let min = arr[0];
  let max = arr[0];
  for (let i = 1; i < n; i++) {
    if (arr[i] > max) {
      max = arr[i];
    }
    if (arr[i] < min) {
      min = arr[i];
    }
  }
  return { max, min };
}
console.log(getMinMax([4, 1, 8, 9, 13, 12, 14, 7], 8));
