// var addDigits = function (num) {
//   if (num < 1) return 0;

//   while (num >= 10) {
//     num = num
//       .toString()
//       .split("")
//       .reduce((sum, digit) => sum + parseInt(digit, 10), 0);
//   }
//   return num;
// };
// console.log(addDigits(38));

// function isPrime(N) {
//   if (N < 4) return "Invalid Input";
//   let prime = true;
//   for (let i = 2; i < N - 1; i++) {
//     if (N % i == 0) {
//       console.log("Divisible By " + i);
//       prime = false;
//       break;
//     }
//   }
//   if (prime) {
//     console.log(N + " is a Prime Number");
//   } else {
//     console.log(N + " is not a Prime Number");
//   }
// }

// console.log(isPrime(10));

// function countPrimes(N) {
//   for (let i = 2; i < N; i++) {
//     let isPrime = true;

//     for (let j = 2; j <= i; j++) {
//       if (i % j === 0) {
//         isPrime = false;
//         break;
//       }
//     }

//     if (isPrime) {
//       console.log(i);
//     }
//   }
// }

// console.log(countPrimes(10));

// function digitcount(n, m) {
//   let count = 0;
//   for (let j = n; j <= m; j++) {
//     let sum = 0;
//     for (let i = j; i > 0; i = Math.floor(i / 10)) {
//       let lastdigit = i % 10;
//       sum += lastdigit;
//     }
//     count += sum;
//     console.log(sum);
//   }
//   console.log(count);
// }
// console.log(digitcount(5096, 5101));

// function arrsort(arr) {
//   let n = arr.length;
//   if (n === 1 || n === 0) return 1;
//   for (let i = 0; i < n; i++) {
//     if (arr[i] > arr[i + 1]) {
//       return 0;
//     } else {
//       return 1;
//     }
//   }
// }
// console.log(arrsort([2, 2, 2, 2]));

// function getMinMax(arr, n) {
//   let min = arr[0];
//   let max = arr[0];
//   for (let i = 1; i < n; i++) {
//     if (arr[i] > max) {
//       max = arr[i];
//     }
//     if (arr[i] < min) {
//       min = arr[i];
//     }
//   }
//   return { max, min };
// }
// console.log(getMinMax([4, 1, 8, 9, 13, 12, 14, 7], 8));

// function maxFreq(arr) {
//   let maxfrek = 0;
//   for (let i = 0; i < arr.length; i++) {
//     maxfrek = Math.max(arr[i]);
//   }
//   let ans = 0;
//   for (let i = 0; i < arr.length; i++) {
//     if (arr[i] == maxfrek) {
//       ans += maxfrek;
//     }
//   }
//   return ans;
// }
// console.log(maxFreq([1, 2, 2, 3, 1, 6]));

// function maxFreq(arr) {
//   let maxFreq = 0;
//   let ans = [];

//   for (let i = 0; i < arr.length; i++) {
//     let occurence = 0;
//     for (let j = 0; j < arr.length; j++) {
//       if (arr[i] === arr[j]) {
//         occurence++;
//       }
//     }

//     if (occurence === maxFreq) {
//       ans.push(arr[i]);
//     } else if (occurence > maxFreq) {
//       maxFreq = occurence;
//       ans = [arr[i]];
//     }
//   }

//   return ans.length;
// }

// console.log(maxFreq([1, 2, 3, 4, 5]));

// function printPattern(rows) {
//   let num = 1;
//   let result = "";
//   for (let i = 1; i <= rows; i++) {
//     let pattern = "";
//     for (let j = 0; j < i; j++) {
//       pattern += num;
//       num = 1 - num;
//     }
//     result += pattern + "\n";
//   }
//   return result;
// }

// console.log(printPattern(5));

function printPyramid(N) {
  for (let i = 1; i <= N; i++) {
    let stars = "";
    let space = "";
    for (let s = 1; s <= N - i; s++) {
      space += " ";
    }
    for (let j = 1; j <= 2 * i - 1; j++) {
      stars += "*";
    }

    console.log(space + stars);
  }
}

// Example usage:
console.log(printPyramid(5));
