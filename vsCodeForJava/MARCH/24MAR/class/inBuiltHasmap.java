import java.util.*;

class Main {
    public static void main(String[] args) {
		HashMap<String, Integer> netWorth = new HashMap<>();

		netWorth.put("Pulkit", 100);
		netWorth.put("Fraz", 1000000000);
		netWorth.put("mrbeast", 200000031);

		System.out.println(netWorth.get("Pulkit"));
		System.out.println(netWorth.getOrDefault("Jasnam", 0));

		netWorth.put("Pulkit", netWorth.get("Pulkit") + 500);
		System.out.println(netWorth.get("Pulkit"));

		System.out.println(netWorth.get("Fraz"));
		netWorth.remove("Fraz");
		System.out.println(netWorth.get("Fraz"));

		// netWorth.put("Pulkit", "gareeb");
    }
}