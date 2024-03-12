
public class hollowSquareStarDiagonal {
    public static void main(String[] args) {
        int N = 11;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r == 1 || r == N || c == 1 || c == N || r == c || r == (N - c + 1))
                    System.out.print("*");
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
