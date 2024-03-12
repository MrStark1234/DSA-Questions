function arrsort(arr) {
  let n = arr.length;
  if (n === 1 || n === 0) return 1;
  for (let i = 0; i < n; i++) {
    if (arr[i] > arr[i + 1]) {
      return 0;
    } else {
      return 1;
    }
  }
}
console.log(arrsort([2, 2, 2, 2]));
