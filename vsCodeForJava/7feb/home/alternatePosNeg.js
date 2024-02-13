//www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1

https: function alternatePositiveNegative(arr) {
  let positive = [];
  let negative = [];
  let result = [];

  for (let num of arr) {
    if (num >= 0) {
      positive.push(num);
    } else {
      negative.push(num);
    }
  }
  let i = 0;
  let j = 0;
  while (i < positive.length && j < negative.length) {
    result.push(positive[i]);
    result.push(negative[j]);
    i++;
    j++;
  }
  while (i < positive.length) {
    result.push(positive[i]);
    i++;
  }
  while (j < negative.length) {
    result.push(negative[j]);
    j++;
  }

  return result;
}

const arr = [9, 4, -2, -1, 5, 0, -5, -3, 2];
console.log(alternatePositiveNegative(arr)); // Output: [9, -2, 4, -1, 5, -5, 0, -3, 2]
