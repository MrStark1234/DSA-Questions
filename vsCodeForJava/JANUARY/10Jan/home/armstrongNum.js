function armstrongNumber(n) {
  if (n <= 100 && n >= 1000) return false;
  let num = n;
  let sum = 0;
  while (num) {
    let rem = num % 10;
    num = Math.floor(num / 10);
    sum = sum + Math.pow(rem, 3);
  }
  if (sum === n) return "Yes";
  else return "No";
}
console.log(armstrongNumber(152));
