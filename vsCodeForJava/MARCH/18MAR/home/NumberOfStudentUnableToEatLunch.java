// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

// Count student's preference of food to count
// Now we iterate the food one by one,
// and see if any one in the left students queue will take it.
// We stop at sandwiches[k] if no one wants it,
// then n - k students are unable to eat.

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count[] = { 0, 0 }, n = students.length, k;
        for (int a : students)
            count[a]++;
        for (k = 0; k < n && count[sandwiches[k]] > 0; ++k)
            count[sandwiches[k]]--;
        return n - k;
    }
}
