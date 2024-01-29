import java.util.Scanner;

public class diamondPattern {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int Star = sc.nextInt();
            int N = sc.nextInt();

            for (int row = 1; row <= N; row++) {
                for (int sp = 1; sp <= (N - row); sp++)
                    System.out.print(" ");

                    for(int st =1;st<=Star;st++)   
                    System.out.print("*");

                    System.out.println("");
                    Star +=2;
            }
        }
    }
}
