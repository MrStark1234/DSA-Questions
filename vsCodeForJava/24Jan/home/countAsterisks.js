//https://leetcode.com/problems/count-asterisks/submissions/1156742079/

var countAsterisks = function (s) {
  let count = 0;
  let barCount = 0;

  for (let i = 0; i < s.length; i++) {
    if (s[i] === "|") {
      barCount++;
    }
    if (barCount % 2 === 0) {
      if (s[i] === "*") {
        count++;
      }
    }
  }
  return count;
};
console.log(countAsterisks("l|*e*et|c**o|*de|"));
