// https://codeforces.com/problemset/problem/1711/A
// CODEFORCES : PERFECT PERMUTATION

function nextPermutation(num) {
  let permutation = `${num} `;
  for (let i = 1; i < num; i++) {
    permutation += `${i} `;
  }
  return permutation;
}
console.log(nextPermutation(4));
