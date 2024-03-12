//https://leetcode.com/problems/make-the-string-great/

var makeGood = function (s) {
  let arr = [...s];

  for (let i = 0; i < arr.length - 1; i++) {
    if (
      arr[i].toLowerCase() === arr[i + 1].toLowerCase() &&
      arr[i] !== arr[i + 1]
    ) {
      arr.splice(i, 2);
      i = Math.max(-1, i - 2);
    }
  }
  return arr.join("");
};
console.log(makeGood("leEeetcode"));
