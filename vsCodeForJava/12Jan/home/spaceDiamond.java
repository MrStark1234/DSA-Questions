
public class spaceDiamond {

    public static void main(String[] args) {
        int N = 6;

        for (int i = 1; i <= N; i++) {
            for(int s= 1; s<=(2*i-2);s++)
            System.out.print(" ");
            for (int j = 1; j <= (N-i)+1; j++)

                System.out.print("*");

            System.out.println("");
        }

        for (int i = 1; i < N; i++) {
            for (int s = 1; s <(2*N)-(2*i)-1; s++)
                System.out.print(" ");
            for (int j = 1; j <= i + 1; j++)

                System.out.print("*");

            System.out.println("");
        }

    }
}
