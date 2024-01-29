public class rightTriangleBorder {
    public static void main(String[] args) {
        
   

                int R = 5;

                for (int i = 1; i <= R; i++) {
                    for (int j = 1; j <= i; j++) {
                        if (i == 1 || i == R || j == 1 || j == i)
                            System.out.print("*");
                        else
                            System.out.print(" ");

                    }
                    System.out.println("");

                }
            }
        }

 