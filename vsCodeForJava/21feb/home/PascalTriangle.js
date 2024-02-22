//Problem Link :- https://www.geeksforgeeks.org/problems/pascal-triangle0652/1

function nthRowOfPascalTriangle(N) {
  //code here
  if (N == 1) {
    let tmp = [];
    tmp.push(1);
    return tmp;
  }
  let tans = this.nthRowOfPascalTriangle(N - 1);
  let ans = [];
  ans.push(1);
  for (let i = 1; i < tans.length; i++) {
    ans.push((tans[i] + tans[i - 1]) % (10 ** 9 + 7));
  }
  ans.push(1);
  return ans;
}
