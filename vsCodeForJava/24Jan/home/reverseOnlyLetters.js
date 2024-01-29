//https://leetcode.com/problems/reverse-only-letters/submissions/1156792538/

var reverseOnlyLetters = function (s) {
  let arr = [...s];
  const onlyEngLetter = (char) => /[a-zA-Z]/.test(char);
  let i = 0,
    j = arr.length - 1;

  while (i < j) {
    if (!onlyEngLetter(arr[i])) {
      i++;
    } else if (!onlyEngLetter(arr[j])) {
      j--;
    } else {
      let temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
  return arr.join("");
};
console.log(reverseOnlyLetters("a-bC-dEf-ghIj"));
