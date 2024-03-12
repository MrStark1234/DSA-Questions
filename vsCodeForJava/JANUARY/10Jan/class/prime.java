import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int N = sc.nextInt();
           
            for(int num = 2;num<=N;num++){
                boolean isPrime = true;
                for(int i = 2;i<num;i++){
                    if(num%i ==0){
                        isPrime=false;
                    }
                   
                }
                 if(isPrime){
                        System.out.println(num);
                    }
            }
            
            
         
               
                sc.close();
            }
        };
    }
    