// var isPowerOfTwo = function (n) {
//   while (n > 0 && n !== 1) {
//     if (n % 2 !== 0) {
//       return false;
//     }
//     n /= 2;
//   }
//   return n === 1;
// };

// console.log(isPowerOfTwo(1));

var isPowerOfTwo = function (n) {
  while (n % 2 === 0) {
    n /= 2;
  }

  return n === 1 ? true : false;
};

console.log(isPowerOfTwo(4));
