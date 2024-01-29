// function GCD(a, b) {
//   let ans = 0;
//   for (let i = 1; i <= Math.min(a, b); i++) {
//     if (a % i === 0 && b % i === 0) {
//       ans = i;
//     }
//   }
//   return ans;
// }
// console.log(GCD(48, 18));

function gcd(a, b) {
  if (b === 0) return a;
  return gcd(b, a % b);
}
console.log(gcd(48, 18));
