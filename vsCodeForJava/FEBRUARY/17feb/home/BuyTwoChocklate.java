
/*
Intuition
basic sorting then we can add first two and get answer

Approach
first lets sort the list in ascending order and add the first two(which will be least)then we subract it from the total money .if its less than equal to 0 then its possible to have balance so return balance.else return the money.

Complexity
Time complexity:
time is O(n).

Space complexity:
space is O(1).
*/
import java.util.Arrays;

public class BuyTwoChocklate {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] + prices[1] <= money) {
            return money - (prices[1] + prices[0]);
        }
        return money;
    }
}