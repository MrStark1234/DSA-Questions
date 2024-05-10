import java.util.Scanner;

class Solution {
    public static void solve() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input
        String str = scanner.next();

        // Check if both characters are equal
        if (str.charAt(0) == str.charAt(1)) {
            System.out.println("String ignored because both characters are equal.");
            scanner.close(); // Close the scanner before returning
            return; // Skip further processing
        }

        int a = str.charAt(0) - 'a';
        int b = str.charAt(1) - 'a';

        if (a < b) {
            System.out.println(a * 25 + b);
        } else {
            System.out.println(a * 25 + b + 1);
        }
        scanner.close(); // Close the scanner after processing
    }
}