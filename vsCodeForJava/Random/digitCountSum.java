import java.util.Scanner;

class digitCountSum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int digits = 0;
            int sum = 0;
            for (; N > 0; N /= 10) {

                System.out.println("Number is " + N + " now");
                int lastDigit = N % 10;
                sum += lastDigit;
                digits++;

            }
            System.out.println("Total Digits of N = " + digits);
            System.out.println("Total sum of N = " + sum);
        }
    }
}