//Leetcode - 122. Best Time to Buy and Sell Stock II
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

/*
Approach

Start with Zero Money:
        Begin with zero money (profit = 0) and set the first stock's price as 
		the initial low price.

Check Each stock:
        Look at each stock's price one by one.
        If you find an stock that is cheaper than your current low price, 
		update the low price to that stock's price.

Earn Money:
        If the difference between the current stock's price and your 
		low price is more than 0 (meaning you can make a profit), add that profit to your money.
        Update the low price to the current stock's price.

Finish the Trading Day:
        After going through all the stocks, the money you earned is your total profit.

*/

class Solution {
    public int maxProfit(int[] prices) {
        // Initialize profit variable to keep track of earnings.
        int profit = 0;
        // Set the initial low price to the first element in the prices array.
        int low = prices[0];

        for (int i = 0; i < prices.length; i++) {
            // If the current price is lower than the current low price, update the low
            // price.
            if (prices[i] < low) {
                low = prices[i];
            }

            // If there's a positive difference between the current price and the low price,
            // it indicates a profitable trade.
            if (prices[i] - low > 0) {
                // Add the profit from the trade to the total profit.
                profit += prices[i] - low;
                // Update the low price to the current price,
                // as we can buy and sell in the same time.
                low = prices[i];
            }
        }

        return profit;
    }
}