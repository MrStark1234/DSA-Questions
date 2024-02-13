function notQuiteLatinSquare() {
  let arr = [
    ["A", "B", "C"],
    ["C", "A", "B"],
    ["B", "C", "?"],
  ];

  let c = [];

  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr[i].length; j++) {
      if (arr[i][j] === "?") {
        c.push(i);
        c.push(j);
      }
    }
  }
  if (c.length === 0) {
    console.log("No letter is missing.");
    return;
  }

  const missingLetter = ["A", "B", "C"].find(
    (letter) => !arr[c[0]].includes(letter)
  );

  return missingLetter || "No Missing letter found.";
}

console.log(notQuiteLatinSquare());
