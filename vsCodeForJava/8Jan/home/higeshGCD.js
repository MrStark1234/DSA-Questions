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

// let suppose gcd is (48, 18);

// if b = 0 return a

// else  b = 18 which is not equal to 0, we proceed to the next step.
// gcd(b, a % b)
// gcd(b = 18,  a = 48 % b = 18):
// 48 % 18 gives 12, so  gcd(a = 18, b = 12).

// gcd(b, a % b)
// gcd(12, 18 % 12):
// 18 % 12 gives 6, so  gcd(12, 6).

// gcd(b, a % b)
// gcd(6, 12 % 6):
// 12 % 6 evaluates to 0, so it becomes gcd(6, 0)
