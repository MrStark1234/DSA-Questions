
import java.io.*;

// Link : https://www.codechef.com/KA19MOS/problems/GVAWAY

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        while (t-- > 0) {
            String line[] = r.readLine().split(" ");
            int L = Integer.parseInt(line[0]);
            int R = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);

            if (L == R)
                w.print(1);
            else
                w.print(k);
            w.print('\n');
        }
        r.close();
        w.close();
    }
}