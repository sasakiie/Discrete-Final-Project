import java.util.Scanner;

public class DeterministicFiniteAutomaton {
    private static final int[][] transitionTable = {
        {1, 2},     // State 0
        {2, 3},     // State 1
        {3, 3}      // State 2 (Final State)
    };
    private static final int initialState = 0;
    private static final int finalState = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentState = initialState;

        System.out.print("Enter input string (0s and 1s only): ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            int symbolIndex = symbol - '0';

            currentState = transitionTable[currentState][symbolIndex];
        }

        if (currentState == finalState) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }

        scanner.close();
    }
}
