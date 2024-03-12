//https://codeforces.com/contest/1920/problem/A

// minValid ko Number.MIN_SAFE_INTEGER se, aur maxValid ko Number.MAX_SAFE_INTEGER se initialize kiya gaya hai, jo sabse chhote aur sabse bade possible integer values hain.

// Ab hum loop ke andar constraints array par iterate karte hain:

// a. Pehla constraint hai [1, 5], jo kehtaa hai ki k 5 ya usse bada hona chahiye. Is constraint ke liye minValid ko 5 mein update karenge.

// b. Dusra constraint hai [2, 10], jo kehtaa hai ki k 10 se chhota hona chahiye. Is constraint ke liye maxValid ko 10 mein update karenge.

// c. Teesra constraint hai [3, 7], jo kehtaa hai ki k 7 ke baraabar nahi hona chahiye. Hum check karte hain ki 7 current valid range ke andar hai ya nahi. Yahan, 7 minValid aur maxValid ke beech mein hai, toh hum maxValid ko 7 mein update karenge.

// Loop khatam hone ke baad, maxValid - minValid ko return karenge, jo ke valid integers ki count hai jo saare constraints ko satisfy karte hain.

//------------------------------------------------------------------------------------------------

// Sabse pehle constraint ke hisaab se,
// �
// k ki value 5 ya usse badi honi chahiye.
// Dusri constraint ke hisaab se,
// �
// k ki value 10 se chhoti honi chahiye.
// Teesri constraint ke hisaab se,
// �
// k ki value 18 nahi honi chahiye.
// Toh humare valid range of values
// �
// k ke liye 5 se 10 tak hai.

// Ab agar hum is range mein count karein:

// 5, 6, 7, 8, 9, 10

// Total 6 integers hain jo saare constraints ko satisfy karte hain.

// Isliye sahi answer 6 hi hai. Mujhe confusion create karne ke liye maafi chahunga. Agar aapko aur kuch poochna hai, toh please pooch sakte hain.

function countValidIntegers(constraints) {
  let minValid = Number.MIN_SAFE_INTEGER;
  let maxValid = Number.MAX_SAFE_INTEGER;

  for (const constraint of constraints) {
    const [type, x] = constraint;

    if (type === 1) {
      minValid = Math.max(minValid, x);
    } else if (type === 2) {
      maxValid = Math.min(maxValid, x);
    } else if (type === 3) {
      if (x >= minValid && x < maxValid) {
        maxValid = x;
      }
    }
  }

  return maxValid - minValid;
}

const constraints = [
  [1, 5], // k must be greater than or equal to 5
  [2, 10], // k must be less than 10
  [3, 7], // k must be not equal to 7
];

console.log(countValidIntegers(constraints)); // Output: 2 (6 and 8 are valid)
