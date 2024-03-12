import java.util.*;

// Time : O(NLogN)

class Main {
    public static boolean isSorted(String str) {
        for (int i = 0; i + 1 < str.length(); ++i) {
            if (str.charAt(i) > str.charAt(i + 1))
                return false;
        }
        return true;
    }

    public static void Reverse(char arr[]) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        char temp[] = s.toCharArray();

        if (t.length() == 1 && s.contains(t)) {
            System.out.println("Impossible");
        }
        // If t is sorted, then reverse sort s
        else if (isSorted(t)) {
            Arrays.sort(temp);
            Reverse(temp);
            System.out.println(new String(temp));
        }
        // Otherwise, simply sort s
        else {
            Arrays.sort(temp);
            System.out.println(new String(temp));
        }
        sc.close();
    }
}
