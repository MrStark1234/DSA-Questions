/*
Checking for Invalid Cases:
If n is greater than 3×limit, it means that it's impossible to distribute the candies among 3 children without violating the limit constraint. In this case, the function returns 0.
Calculating Total Ways:

Initialize a variable res to the result of combo(n+2). This represents the total number of ways to distribute n candies among 3 children without any constraints.

Adjusting for Limit:
If n is greater than limit, subtract 3×combo(n−limit+1) from res. This adjustment accounts for cases where one or more children receive more than the limit. This subtraction is performed for each child, hence the factor of 3.

Adjusting for Lower Limit:
If n−2 is greater than or equal to 2×limit, add 3×combo(n−2×limit) to res. This adjustment handles cases where one or more children receive less than the limit, ensuring the limit is not violated.

Final Result:
The final result res represents the total number of ways to distribute n candies among 3 children, considering the limit constraint.

Complexity
Time complexity: O(1)
Space complexity: O(1)
*/

class Solution {
    public int distributeCandies(int n, int limit) {
        java.util.function.Function<Integer, Long> comb = x -> 1L * x * (x - 1) / 2;

        // Check if n is greater than 3 times limit
        if (n > 3 * limit) {
            return 0;
        }

        long ans = comb.apply(n + 2);

        if (n > limit) {
            ans -= 3 * comb.apply(n - limit + 1);
        }

        if (n - 2 >= 2 * limit) {
            ans += 3 * comb.apply(n - 2 * limit);
        }

        // Return the final result
        return (int) ans;
    }
}
