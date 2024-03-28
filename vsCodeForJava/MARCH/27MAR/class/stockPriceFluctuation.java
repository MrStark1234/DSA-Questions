import java.util.*;

// Link : leetcode.com/problems/stock-price-fluctuation/

class StockPrice {
    HashMap<Integer, Integer> timeToPrice;
    TreeMap<Integer, Integer> priceToFreq;
    int latestTime;

    public StockPrice() {
        latestTime = 0;
        timeToPrice = new HashMap<>();
        priceToFreq = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        latestTime = Math.max(latestTime, timestamp);

        // Decrement the frequency of oldPrice (if exists)
        if (timeToPrice.containsKey(timestamp)) {
            int oldPrice = timeToPrice.get(timestamp);
            int freqOfOldPrice = priceToFreq.get(oldPrice);

            if (freqOfOldPrice == 1)
                priceToFreq.remove(oldPrice);
            else
                priceToFreq.put(oldPrice, freqOfOldPrice - 1);
        }

        // Increment the frequency of the new price
        int curFreqOfNewPrice = priceToFreq.getOrDefault(price, 0);
        priceToFreq.put(price, curFreqOfNewPrice + 1);

        // Update price of timestamp to 'price' in timeToPrice
        timeToPrice.put(timestamp, price);
    }

    public int current() { // O(1)
        return timeToPrice.get(latestTime);
    }

    public int maximum() { // O(logN)
        return priceToFreq.lastKey();
    }

    public int minimum() { // O(logN)
        return priceToFreq.firstKey();
    }
}
