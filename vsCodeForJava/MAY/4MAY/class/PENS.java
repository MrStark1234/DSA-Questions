
import java.io.*;

class Main {
    static int stringToMask(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int bit = s.charAt(i) - 'a';
            ans += (1 << bit);
        }
        return ans;
    }

    static int mask(char ch) {
        int bit = ch - 'a';
        return 1 << bit;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        while (t-- > 0) {
            String line[] = r.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            String s = r.readLine();

            int pen[] = new int[1 << 20];
            for (int i = 0; i < k; ++i) {
                String Pi = r.readLine();
                int m = stringToMask(Pi);
                pen[m] = i + 1;
            }

            /*
             * Do some processing on the pen array.
             * So, that it also starts considering
             * all the subsets of the Pi strings.
             */
            for (int m = (1 << 20) - 1; m >= 1; --m) {
                for (int i = 0; i < 20; ++i) {
                    if (pen[m] > 0)
                        break;
                    if (((m >> i) & 1) > 0)
                        continue;
                    pen[m] = pen[m | (1 << i)];
                }
            }
            /*
             * pen[m] = 0 : if it's impossible to write that set of characters with a single
             * pen
             * pen[m] = i : ith pen can be used to write this particular set of character.
             */

            int i = 0;
            while (i < n) {
                int curSet = mask(s.charAt(i)), j = i + 1; // next probable character
                while (j < n && pen[curSet | mask(s.charAt(j))] > 0) {
                    curSet |= mask(s.charAt(j));
                    j++;
                }

                for (int id = i; id < j; ++id)
                    w.print(pen[curSet] + " ");

                i = j;
            }

            w.print("\n");
        }
        r.close();
        w.close();
    }
}
