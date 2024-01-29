import java.util.Scanner;

class two {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int targetCount = sc.nextInt();
            int targetSum = sc.nextInt();
            int cur_num = 1, count = 0;

          while(count < targetCount){
            int cur_sum = 0;
            for(int num = cur_num; num>0;num /= 10){
                cur_sum += (num%10);
            }
                if(cur_sum == targetSum){
                    System.out.println(cur_num);
                    count ++;
                }
                cur_num++;
           
          }
          sc.close();
        }

    }
}
