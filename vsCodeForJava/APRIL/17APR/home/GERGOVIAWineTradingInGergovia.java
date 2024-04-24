
/*
Since every element is needed to become zero so just 
keep on accumulating the total work . Suppose the first 
element is non-zero then it must be transferred to the 
next element so whether it is positive or negative you
 have to transfer it all. And the work will be absolute 
 value of the transferred element.
In this way you just need to sum it up till the last 
term and you will get the total work.
*/

import java.io.IOException;

import java.util.*;

public class GERGOVIAWineTradingInGergovia {
    public static long NumberOfPersons;
    public static long[] Bottles;
    public static long Sum;

    public static void main(String args[]) throws NumberFormatException, IOException {
        Scanner Input = new Scanner(System.in);

        while (Input.hasNext()) {
            NumberOfPersons = Input.nextLong();
            if (NumberOfPersons == 0)
                break;

            Bottles = new long[100000 + 1];

            for (int i = 0; i < NumberOfPersons; i++)
                Bottles[i] = Input.nextLong();

            long Result = 0;
            for (int i = 1; i < NumberOfPersons; i++) {
                Sum = Bottles[i - 1];
                Bottles[i] += Bottles[i - 1];

                Result += (Sum < 0) ? (Sum * -1) : Sum;
            }
            System.out.println(Result);
        }
        Input.close();

    }

}