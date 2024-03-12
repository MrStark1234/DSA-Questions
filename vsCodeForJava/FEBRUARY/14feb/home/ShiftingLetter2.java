//  Shifting Letters II
//  https://leetcode.com/problems/shifting-letters-ii/description/

/*
    We will perform total three passes:

    In first pass we traverse shifts vector: we will put value in vector,
    if(shifts[i][2]==1), then do +=1 at shifts[i][0] index & -=1 at shifts[i][0]+1 index of vector(prefixsum)
    else ,do -=1 at shifts[i][0] index & +=1 at shifts[i][0]+1 index of vector(prefixsum)

    In second pass we traverse vector and do prefixsum to find displacement of character at index i

    In third pass we traverse string and shift the character ((s[i]-'a')+vec[i])%26 places from 'a'
*/

public class ShiftingLetter2 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] vec = new int[n + 1];

        // Fill vec with cumulative shift values
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];
            if (dir == 1) {
                vec[start]++;
                vec[end + 1]--;
            } else {
                vec[start]--;
                vec[end + 1]++;
            }
        }

        // Calculate prefix sum for cumulative shifts
        for (int i = 1; i <= n; i++) {
            vec[i] += vec[i - 1];
        }

        // Shift each character and wrap around alphabet
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shiftedIndex = (charArray[i] - 'a' + vec[i]) % 26;
            if (shiftedIndex < 0) {
                shiftedIndex += 26;
            }
            charArray[i] = (char) ('a' + shiftedIndex);
        }

        return new String(charArray);
    }
}
