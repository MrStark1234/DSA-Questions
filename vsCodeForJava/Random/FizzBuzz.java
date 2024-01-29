import java.util.Scanner;

class FizzBuzz {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int input = sc.nextInt();
            int sum = 0;

            for (int i = 1; i <= input; i++) {
                // if(i%4== 0 ){
                // continue; extra statement for using "continue"
                // }
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.print("FizzBuzz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else {
                    System.out.println(i);
                    sum = sum + i;

                }

                if (sum > 2 * input) {
                    break;
                }
                // Extra statement for using break statement
            }
            System.out.println("Sum of I is" + sum);
            sc.close();
        }
    }
}