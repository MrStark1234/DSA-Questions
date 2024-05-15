// https://www.codechef.com/problems/RNDPAIR

// Favourable Outcome: Just count the number of times the
// maximum sum appears. For Total Outcome : Sum of total integers in the array.
// The answer is : Favourable Outcome / Total Outcome.

import java.util.*;

class Codechef {
    public static int counter(int[] arr) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] > sum) {
                    count = 1;
                    sum = arr[i] + arr[j];
                } else if (arr[i] + arr[j] == sum) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            double possibleOutcome = counter(arr);
            double totalOutcome = (n * (n - 1)) / 2;

            double ans = possibleOutcome / totalOutcome;

            System.out.println(ans);
        }

        sc.close();
    }
}