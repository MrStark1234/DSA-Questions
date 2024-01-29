import java.util.Scanner;

class evenNumber {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int N = sc.nextInt();

            for (int num = 1; num <= N; num++) {
                // Adding a variation were number is devisible by both 2 and 7
                if (num % 2 == 0 && num % 7 == 0) {
                    System.out.println(num);
                }
            }
            sc.close();
        }

    }
}
