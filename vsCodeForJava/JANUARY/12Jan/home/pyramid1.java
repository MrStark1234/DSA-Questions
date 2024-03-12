public class pyramid1 {
    public static void main(String[] args) {
        int N = 11;
        int star = 1;

        for (int i = 1; i <= N; i++) {
            for (int s = 1; s <= (N - i); s++)
                System.out.print(" ");

            for (int j = 1; j <= star; j++) // (2*i-1) we also use this approach.
                System.out.print("*");

            System.out.println("");
            star += 2;
        }
    }
}
