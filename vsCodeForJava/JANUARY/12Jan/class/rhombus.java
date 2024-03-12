import java.util.Scanner;

class rhombus {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int stars = sc.nextInt();
            for(int row=1;row<=stars;row++){
               
                for(int sp=1;sp<=(row-1);sp++)
                System.out.print(" ");

               for(int i = 1;i<=stars;i++)
                 System.out.print("*");
               
            System.out.println("");
        }
        sc.close();
        }
    }
} 