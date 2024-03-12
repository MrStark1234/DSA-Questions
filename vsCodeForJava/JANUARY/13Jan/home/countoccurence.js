function count(arr, n, x) {
  let inc = 0;
  for (let i = 1; i < n; i++) {
    if (x === arr[i]) {
      inc++;
    }
  }
  return { inc };
}
console.log(count([1, 3, 4, 5, 6, 7, 8], 7, 2));
