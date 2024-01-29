
//https://leetcode.com/problems/jewels-and-stones/
import java.util.*;

class jewelsStone {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String stones = sc.nextLine();
   
            String jewels = sc.nextLine();
            int ascii[] = new int[128];
            for (int i = 0; i < stones.length(); i++) {
                int id = stones.charAt(i);
                if (jewels.indexOf(id) != -1) {
                    ascii[id]++;
             
                }
                ;
         

            }
            
            ;
            int jewelsCount = 0;
            for (int j = 0; j < jewels.length(); j++) {
                jewelsCount += ascii[jewels.charAt(j)];
            }
            ;
           System.out.println(jewelsCount);
  
           

        }
    }
}