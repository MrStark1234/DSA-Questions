public class diamond {
  

        public static void main(String[] args) {
            int N = 6;
            int star = 1;

            for (int i = 1; i <= N; i++) {
                for (int s = 1; s <= (N - i); s++)
                    System.out.print(" ");

                for (int j = 1; j <= star; j++) // (2*i-1) we also use this approach.
                    System.out.print("*");

                System.out.println("");
                star += 2;
            }

        
            star= 2*(N-1)-1;
            for (int i = 1; i <= N; i++) {
                for (int s = 1; s <= i; s++)
                    System.out.print(" ");

                for (int j = 1; j <= star; j++) { // (2*N -(2*i-1)) ye bhi approach kar sakte hai hum

                    System.out.print("*");

                }

                System.out.println("");
                star -= 2;
            }
        }
    }

