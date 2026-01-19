import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StateCapitals2 {

    private static final String FILE_NAME = "StateCapitals.txt";
    private static final String DELIMITER = "::";

    public static void main(String[] args) {
        Map<String, String> stateCapitals;

        try {
            stateCapitals = loadStateCapitals(FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error: Could not read " + FILE_NAME);
            System.out.println("Make sure the file is in the project top level (working directory).");
            return;
        }

        // 1) Print count
        System.out.println(stateCapitals.size() + " STATES & CAPITALS ARE LOADED.");
        System.out.println("======");

        // 2) Print all states
        System.out.println("HERE ARE THE STATES :");
        printStates(stateCapitals);
        System.out.println();

        // 3) Knowledge game (stretch included)
        runQuiz(stateCapitals);
    }

    private static Map<String, String> loadStateCapitals(String fileName) throws IOException {
        Map<String, String> map = new HashMap<>();

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                // Skip empty lines
                if (line.isEmpty()) continue;

                // Split into state and capital
                String[] parts = line.split(DELIMITER);

                // Skip malformed lines
                if (parts.length < 2) continue;

                String state = parts[0].trim();
                String capital = parts[1].trim();

                // Only add if both are non-empty
                if (!state.isEmpty() && !capital.isEmpty()) {
                    map.put(state, capital);
                }
            }
        }

        return map;
    }

    private static void printStates(Map<String, String> stateCapitals) {
        // Print one per line (cleanest and matches "print out all state names")
        for (String state : stateCapitals.keySet()) {
            System.out.println(state);
        }
    }

    private static void runQuiz(Map<String, String> stateCapitals) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("READY TO TEST YOUR KNOWLEDGE?");
        System.out.print("How many would you like to guess? ");

        int numQuestions;
        while (true) {
            if (input.hasNextInt()) {
                numQuestions = input.nextInt();
                input.nextLine(); // consume newline
                break;
            } else {
                input.nextLine(); // discard invalid input
                System.out.print("Please enter a whole number: ");
            }
        }

        if (numQuestions <= 0) {
            System.out.println("No questions selected. Goodbye!");
            return;
        }

        int available = stateCapitals.size();
        numQuestions = Math.min(numQuestions, available);

        // Turn keys into a list so we can pick random indices
        List<String> states = new ArrayList<>(stateCapitals.keySet());

        // Track states already used so we don't repeat
        Set<String> used = new HashSet<>();

        int score = 0;

        for (int i = 1; i <= numQuestions; i++) {
            String state;

            // Choose a random state that hasn't been used yet
            do {
                state = states.get(rand.nextInt(states.size()));
            } while (used.contains(state));

            used.add(state);

            String correctCapital = stateCapitals.get(state);

            System.out.println();
            System.out.print("Question " + i + ": WHAT IS THE CAPITAL OF '" + state + "'? ");
            String guess = input.nextLine().trim();

            if (guess.equalsIgnoreCase(correctCapital)) {
                System.out.println("NICE WORK! " + correctCapital + " IS CORRECT!");
                score += 1;
            } else {
                System.out.println("Sorry, that is incorrect. The capital of " + state + " is " + correctCapital + ".");
                score -= 1;
            }
        }

        System.out.println();
        System.out.println("Quiz complete!");
        System.out.println("Final score: " + score);
    }
}
