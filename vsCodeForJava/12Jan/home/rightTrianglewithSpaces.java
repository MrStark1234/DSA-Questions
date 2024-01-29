public class rightTrianglewithSpaces {
    public static void main(String[] args) {

        int R = 5;

        for (int i = 1; i <= R; i++) {
            for(int s = 1;s<=(R-i);s++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++) {
             
                    System.out.print("*");
               
                  
            }
            System.out.println("");

        }
    }
}
