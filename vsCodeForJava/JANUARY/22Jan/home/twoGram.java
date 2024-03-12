import java.util.Scanner;

public class twoGram {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){

        int n = scanner.nextInt();
        scanner.nextLine();

        String s = scanner.nextLine();

        

        int maxOccurrences = 0;
        String maxTwoGram = "";

        for (int i = 0; i < n - 1; i++) {
            String currentTwoGram = s.substring(i, i + 2);
            int occurrences = s.split(currentTwoGram, -1).length - 1;

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                maxTwoGram = currentTwoGram;
            }
        }

        System.out.println(maxTwoGram);
    }
}
}

