import java.util.Scanner;

class squareStar {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int stars = sc.nextInt();
            for(int row=1;row<=stars;row++){
               
            
               for(int i = 1;i<=stars;i++)
                 System.out.print("*");
               
            System.out.println("");
        }
        }
    }
}