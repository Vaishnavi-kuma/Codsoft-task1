import java.util.Random;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {

        playNumberGuessingGame();
    }

    private static void playNumberGuessingGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("I have generated a number between " + lowerBound + " and " + upperBound +
                    ". Can you Please guess what it is?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess Number: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in "
                            + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("You have entered Too low number! Try again.");
                } else {
                    System.out.println("You have entered Too high number! Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("I am so Sorry, you have used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }

        System.out.println("Thank You for playing the game! Your final score is: " + score);
        scanner.close();
    }
}

