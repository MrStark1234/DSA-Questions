//https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

function minPlatformsRequired(arr, dep) {
  arr.sort((a, b) => a - b);
  dep.sort((a, b) => a - b);

  let platformsNeeded = 1;
  let maxPlatformsNeeded = 1;
  let i = 1;
  let j = 0;

  while (i < arr.length && j < dep.length) {
    if (arr[i] <= dep[j]) {
      platformsNeeded++;
      i++;
    } else {
      platformsNeeded--;
      j++;
    }
    maxPlatformsNeeded = Math.max(maxPlatformsNeeded, platformsNeeded);
  }

  return maxPlatformsNeeded;
}

// Example usage:
const arr = [900, 940, 950, 1100, 1500, 1800];
const dep = [910, 1200, 1120, 1130, 1900, 2000];
const platforms = minPlatformsRequired(arr, dep);
console.log("Minimum platforms required:", platforms); // Output: 3
