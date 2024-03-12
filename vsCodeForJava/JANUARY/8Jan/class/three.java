import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int N = sc.nextInt();
            boolean isPrime = true;
            
           if(N < 4)
                    System.out.println("Invalid input");

            for(int i = 2; i< N-1;i++){
               if(N % i == 0){
                System.out.println("Divisible By " + i);
                   isPrime=false;
                     break;
                }
                }
                if(isPrime){
                    System.out.println(N + " is a Prime Number");
                }else{
                    System.out.println(N + " is not a Prime Number");
                }
                sc.close();
            }
        };
    }
    

