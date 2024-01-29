// https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
// LEETCODE : COUNT ELEMENTS WITH MAXIMUM FREQUENCY

function maxFreq(arr) {
  let maxFreq = 0;
  let ans = [];

  for (let i = 0; i < arr.length; i++) {
    let occurence = 0;
    for (let j = 0; j < arr.length; j++) {
      if (arr[i] === arr[j]) {
        occurence++;
      }
    }

    if (occurence === maxFreq) {
      ans.push(arr[i]);
    } else if (occurence > maxFreq) {
      maxFreq = occurence;
      ans = [arr[i]];
    }
  }

  return ans.length;
}

console.log(maxFreq([1, 2, 3, 4, 5]));
