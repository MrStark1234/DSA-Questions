import java.util.Scanner;

class sumOfFirstAndLastDigit {
    public static void main(String[] args) {
        // you code goes here
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

      

        String s = Integer.toString(N);

        int firstDig = s.charAt(0) - '0'; // 1
        int lastDig = s.charAt(s.length() - 1) - '0'; // 3

        System.out.println(firstDig + lastDig);
          sc.close();
    }
}

/*
'0' -> 48
'1' -> 49
'2' -> 50
'3' -> 51
....
'7' -> 55
*/