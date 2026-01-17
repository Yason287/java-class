import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StateCapitals {
    public static void main(String[] args) {

        // Create a HashMap where:
        // Key   = State name
        // Value = Capital city
        Map<String, String> stateCapitals = new HashMap<>();

        // Add state/capital pairs to the map (hard-coded)
        stateCapitals.put("Alabama", "Montgomery");
        stateCapitals.put("Alaska", "Juneau");
        stateCapitals.put("Arizona", "Phoenix");
        stateCapitals.put("Arkansas", "Little Rock");

        // Get the set of all state names (keys) from the map
        Set<String> keys = stateCapitals.keySet();

        // Print all state names
        System.out.println("STATES");
        System.out.println("======");
        for (String k : keys) {
            System.out.println(k);
        }

        System.out.println();

        // Get the collection of all capital names (values) from the map
        Collection<String> capValues = stateCapitals.values();

        // Print all capital names
        System.out.println("CAPITALS");
        System.out.println("======");
        for (String c : capValues) {
            System.out.println(c);
        }

        System.out.println();

        // Print each state along with its corresponding capital
        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("====================");
        for (String k : keys) {
            // For each state (key), retrieve and print its capital (value)
            System.out.println(k + " - " + stateCapitals.get(k));
        }
    }
}
