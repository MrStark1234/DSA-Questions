import javafx.util.Pair;

class Main {
    final int mod = 1000000007;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    Pair<Integer, Integer> extendedEuclid(int a, int b) {
        if (b == 0)
            return new Pair(1, 0);
        Pair<Integer, Integer> partialSol = extendedEuclid(b, a % b);
        int xPartial = partialSol.getKey(), yPartial = partialSol.getValue();
        return new Pair(yPartial, xPartial - (a / b) * yPartial);
    }

    int modInverse(int a) {
        int x = extendedEuclid(a, mod).getKey();
        x = (x % mod + mod) % mod;
        return x;
    }

    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}