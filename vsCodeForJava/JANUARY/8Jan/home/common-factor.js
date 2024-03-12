function commonfactor(a, b) {
  let ans = 0;
  for (let i = 0; i <= (a, b); i++) {
    if (a % i === 0 && b % i === 0) {
      ans++;
    }
  }
  return ans;
}
console.log(commonfactor(25, 30));
