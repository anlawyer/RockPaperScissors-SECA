import java.util.Random;
import java.util.Scanner;

public class Game {
    // initialize scanner receiving input
    Scanner scanner = new Scanner(System.in);

    Game() {
        // intro to game
        System.out.println("Welcome!");
        System.out.println("Would you like to play against the computer or a friend?");
        System.out.println("Type: computer or friend.");
        this.startGame();
    }

    public void startGame() {
        String determinePlayer = scanner.nextLine();
        if (determinePlayer.toLowerCase().equals("computer")) {
            System.out.println("You want to play: " + determinePlayer);
            this.computerPlayer();
        } else if (determinePlayer.toLowerCase().equals("friend")) {
            System.out.println("friend loop " + determinePlayer);
        } else if(determinePlayer.toLowerCase().equals("exit")) {
            System.out.println("Thank you for playing!");
        } else {
            System.out.println("Would you like to play against the computer, a friend, or exit?");
            this.startGame();
        }
    }

    public void computerPlayer () {
        System.out.println("Enter your play! Type: rock, paper, or scissors.");

        String playersPlay = scanner.nextLine();
        System.out.println("You played: " + playersPlay.toLowerCase());

        Random randomPlay = new Random();
        int computersRand = randomPlay.nextInt(3);
        String computersPlay;

        if (computersRand == 0) {
            computersPlay = "rock";
        } else if (computersRand == 1) {
            computersPlay = "paper";
        } else {
            computersPlay = "scissors";
        }
        System.out.println("Computer played: " + computersPlay);

        String playAgain = "no";
        if (computersPlay.equals(playersPlay.toLowerCase())) {
            System.out.println("Tied game! Play again.");
            playAgain = "tied";
        } else if (playersPlay.toLowerCase().equals("rock") && computersPlay.equals("paper")) {
            System.out.println("Computer wins! Play again?");
            playAgain = scanner.nextLine();
        } else if (playersPlay.toLowerCase().equals("paper") && computersPlay.equals("rock")) {
            System.out.println("Player wins! Play again?");
            playAgain = scanner.nextLine();
        } else if (playersPlay.toLowerCase().equals("paper") && computersPlay.equals("scissors")) {
            System.out.println("Computer wins! Play again?");
            playAgain = scanner.nextLine();
        } else if (playersPlay.toLowerCase().equals("scissors") && computersPlay.equals("paper")) {
            System.out.println("Player wins! Play again?");
            playAgain = scanner.nextLine();
        } else if (playersPlay.toLowerCase().equals("scissors") && computersPlay.equals("rock")) {
            System.out.println("Computer wins! Play again?");
            playAgain = scanner.nextLine();
        } else if (playersPlay.toLowerCase().equals("rock") && computersPlay.equals("scissors")) {
            System.out.println("Player wins! Play again?");
            playAgain = scanner.nextLine();
        }
        switch (playAgain) {
            case "yes":
                Game nextRound = new Game();
                break;
            case "tied":
                this.computerPlayer();
                break;
            default:
                System.out.println("Thanks for playing!");
                break;
        }
    }
}
