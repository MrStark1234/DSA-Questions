public class rightTrinagleReverse {
    public static void main(String[] args) {

        int R = 5;

        for (int i = 1; i <= R; i++) {
           
            for (int j = 1; j <= (R-i+1); j++) 
              System.out.print("*");

            System.out.println("");

        }
    }
}
