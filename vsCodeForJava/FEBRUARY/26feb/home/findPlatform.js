//https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

function minPlatformsRequired(arrival, departure) {
  arrival.sort((a, b) => a - b);
  departure.sort((a, b) => a - b);

  let platformsNeeded = 1;
  let maxPlatformsNeeded = 1;
  let i = 1;
  let j = 0;

  while (i < arrival.length && j < departure.length) {
    if (arrival[i] <= departure[j]) {
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
const arrival = [900, 940, 950, 1100, 1500, 1800];
const departure = [910, 1200, 1120, 1130, 1900, 2000];
const platforms = minPlatformsRequired(arrival, departure);
console.log("Minimum platforms required:", platforms); // Output: 3
