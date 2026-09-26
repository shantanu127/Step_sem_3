import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String generateComputerMove(Random random) {
        return MOVES[random.nextInt(MOVES.length)];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 5;
        int wins = 0, losses = 0, draws = 0;

        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        System.out.println("=== Starting Rock-Paper-Scissors Match ===");

        for (int i = 0; i < totalRounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine().trim();

            try {
                if (!playerMove.equalsIgnoreCase("Rock") && 
                    !playerMove.equalsIgnoreCase("Paper") && 
                    !playerMove.equalsIgnoreCase("Scissors")) {
                    throw new IllegalArgumentException("Invalid move! Please enter Rock, Paper, or Scissors.");
                }

                String computerMove = generateComputerMove(random);
                String result = playRound(playerMove, computerMove);

                playerMoves[i] = playerMove;
                computerMoves[i] = computerMove;
                results[i] = result;

                if (result.equals("Player Wins")) {
                    wins++;
                } else if (result.equals("Computer Wins")) {
                    losses++;
                } else {
                    draws++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Re-trying round.");
                i--; // Repeat current round
            }
        }

        // Summary Table
        System.out.println("\n================ SCOREBOARD ================");
        System.out.printf("%-8s | %-12s | %-13s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8d | %-12s | %-13s | %-12s\n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("--------------------------------------------");

        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                wins, losses, draws, winPercentage);

        scanner.close();
    }
}