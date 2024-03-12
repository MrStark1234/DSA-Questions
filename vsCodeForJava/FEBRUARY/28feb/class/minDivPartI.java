import java.io.*;

import java.util.*;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;

// Link : https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
// Time : O(NLogN)

class Result {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < arr.size(); ++i)
            ans = Math.min(ans, arr.get(i + 1) - arr.get(i));
        return ans;
    }

}

public class minDivPartI {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
