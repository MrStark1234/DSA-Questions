// Given two integers targetCount and targetSum, find and print the first targetCount integers whose digits sum up to targetSum. The program should output these integers in increasing order.
// Example:
// Suppose the user inputs targetCount = 3 and targetSum = 5.

// The program will find and print the first three integers whose digits' sum equals 5.
// For example, if the digits' sum of a number is 5, it can be 5, 14, 23, etc.
import java.util.Scanner;

class two {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int targetCount = sc.nextInt();
            int targetSum = sc.nextInt();
            int cur_num = 1, count = 0;

            while (count < targetCount) {
                int cur_sum = 0;
                for (int num = cur_num; num > 0; num /= 10) {
                    cur_sum += (num % 10);
                }
                if (cur_sum == targetSum) {
                    System.out.println(cur_num);
                    count++;
                }
                cur_num++;

            }
            sc.close();
        }

    }
}
