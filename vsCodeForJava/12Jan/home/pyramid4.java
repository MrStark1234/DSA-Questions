public class pyramid4 {

    public static void main(String[] args) {
        int N = 15;
        int star = N;

        for (int i = 1; i <= N; i++) {
            for (int s = 1; s <= i; s++)
                System.out.print(" ");

            for (int j = 1; j <= star; j++) { // (2*N -(2*i-1)) ye bhi approach kar sakte hai hum
                if (i == 1 || i == N || j == 1 || j == star)
                    System.out.print("*");

                else
                    System.out.print(" ");
            }

            System.out.println("");
            star -= 2;
        }
    }
}