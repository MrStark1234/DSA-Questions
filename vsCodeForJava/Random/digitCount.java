import java.util.Scanner;

class digitCount{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int digits = 0;
            int sum = 0;
            for(int num = N;num>0;num/=10){
                System.out.println("Number is "+ num + "now");
           
                 digits ++;
               
            }
            System.out.println(digits);
            System.out.println(sum);
        }
    }
}
