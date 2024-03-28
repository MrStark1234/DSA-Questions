import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            Queue<Integer> q = new ArrayDeque<>();
            q.add(2);
            q.add(3);
            q.add(5);
            for (int i = 0; i < n - 1; ++i) {
                int num = q.poll();
                q.add(10 * num + 2);
                q.add(10 * num + 3);
                q.add(10 * num + 5);
            }

            System.out.println(q.peek());
        }
    }
}