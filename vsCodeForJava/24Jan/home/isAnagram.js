//https://leetcode.com/problems/valid-anagram/submissions/1156802672/

var isAnagram = function (s, t) {
  if (s.length != t.length) return false;

  s = s.split("").sort().join("");
  t = t.split("").sort().join("");
  if (s !== t) {
    return false;
  }
  return true;
};
console.log(isAnagram("anagram", "nagaram"));
