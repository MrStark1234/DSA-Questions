/*
Q1 - Different queries
Question Link - https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/practice-problems/algorithm/jumbled-queries-afb23321/

Logic Discussion -
Let's divide the queries into three types:
	1. Add type query with negative X - call it decrement type
	2. Add type query with positive X - call it increment type
	3. Set type query

Now let's think about the case when the array has only one element.
In this case we need to maximize the element (lexicographically largest).

How can we do that?
	1. First we should apply the decrement type queries
	2. Then we should apply the set type queries in order of increasing value of X
		~ This will be equivalent to ignoring the decrement type queries and all the set queries with smaller values of X.
	3. Then apply increment type queries.

How can we use this method in case of any generic array?
If we maximize each element in the array, the array will automatically become lexicographically largest
So,we can follow the same procedure as above to get the final array

Time Complexity - O(Q*log(Q) + Q*N) ~ Very tight constraints but the solution passes
Space Complexity - O(N + Q*3)
*/

import java.util.*;

public class differentQueries {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            long[] arr = new long[n];

            // Taking input for the array
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
            }

            // Three separate lists to store the three types of queries
            List<int[]> decrementQueries = new ArrayList<>();
            List<int[]> incrementQueries = new ArrayList<>();
            List<int[]> setQueries = new ArrayList<>();

            // Processing queries
            while (q-- > 0) {
                int t = scanner.nextInt();
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int x = scanner.nextInt();
                if (t == 1) {
                    if (x > 0) {
                        incrementQueries.add(new int[] { x, l, r });
                    } else {
                        decrementQueries.add(new int[] { x, l, r });
                    }
                } else {
                    setQueries.add(new int[] { x, l, r });
                }
            }

            // Sorting the set queries based on the value of X
            Collections.sort(setQueries, Comparator.comparingInt(o -> o[0]));

            // Updating the original array
            for (int[] query : decrementQueries) {
                for (int i = query[1] - 1; i < query[2]; i++) {
                    arr[i] += query[0];
                }
            }
            for (int[] query : setQueries) {
                for (int i = query[1] - 1; i < query[2]; i++) {
                    arr[i] = query[0];
                }
            }
            for (int[] query : incrementQueries) {
                for (int i = query[1] - 1; i < query[2]; i++) {
                    arr[i] += query[0];
                }
            }

            // Outputting the updated array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
