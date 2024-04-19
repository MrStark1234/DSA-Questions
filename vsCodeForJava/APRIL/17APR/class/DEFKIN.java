// Link : https://www.spoj.com/problems/DEFKIN/
// Time : O(NlogN)

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        while (t-- > 0) {
            String line[] = r.readLine().split(" ");
            int w = Integer.parseInt(line[0]);
            int h = Integer.parseInt(line[1]);
            int n = Integer.parseInt(line[2]);

            if (n == 0) { // Needs to be handled separately
                wr.print(h * w);
                wr.print('\n');
                continue;
            }

            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                String xy[] = r.readLine().split(" ");
                x.add(Integer.parseInt(xy[0]));
                y.add(Integer.parseInt(xy[1]));
            }

            Collections.sort(x);
            Collections.sort(y);

            int width = Math.max(x.get(0) - 1, w - x.get(n - 1));
            int height = Math.max(y.get(0) - 1, h - y.get(n - 1));

            for (int i = 1; i < n; ++i) {
                width = Math.max(width, x.get(i) - x.get(i - 1) - 1);
                height = Math.max(height, y.get(i) - y.get(i - 1) - 1);
            }

            wr.print(height * width);
            wr.print('\n');
        }
        r.close();
        wr.close();
    }
}