import java.util.Random;
import java.util.Scanner;

public class Game {
    // initialize scanner receiving input
    Scanner scanner = new Scanner(System.in);
    Player player1 = new Player();

    Game() {
        // intro to game, call startGame method
        System.out.println("Welcome!");
        System.out.println("Would you like to play against the computer or a friend?");
        System.out.println("Type: computer or friend.");
        this.startGame();
    }

    // call proper play method depending on user's desire
    public void startGame() {
        String determinePlayer = scanner.nextLine();
//        try {
            if (determinePlayer.toLowerCase().equals("computer")) {
                System.out.println("You're about to play the: " + determinePlayer);
                this.computerPlayer();
            } else if (determinePlayer.toLowerCase().equals("friend")) {
                System.out.println("You're about to play your: " + determinePlayer);
            } else if (determinePlayer.toLowerCase().equals("exit")) {
                System.out.println("Thanks for playing!");
            }
            else {
//                throw new Exception(InputMismatchException);
                System.out.println("Would you like to play against the computer, a friend, or exit?");
                this.startGame();
            }
//        }
//        catch () {
//            // handle improper input
//            System.out.println("Would you like to play against the computer, a friend, or exit?");
//            this.startGame();
//        }
    }

    public void computerPlayer () {
        System.out.println("Enter your play! Type: rock, paper, or scissors.");

        String playersPlay = scanner.nextLine();
        player1.play = playersPlay.toLowerCase();
        System.out.println("You played: " + player1.play);

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

        if (computersPlay.equals(player1.play)) {
            System.out.println("Tied game! Play again.");
            playAgain = "tied";
        } else if (player1.play.equals("rock") && computersPlay.equals("paper")) {
            System.out.println("Computer wins! Play again?");
            player1.outcome = "lost";
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("paper") && computersPlay.equals("rock")) {
            System.out.println("Player wins! Play again?");
            player1.points += 1;
            player1.outcome = "won";
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("paper") && computersPlay.equals("scissors")) {
            System.out.println("Computer wins! Play again?");
            player1.outcome = "lost";
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("scissors") && computersPlay.equals("paper")) {
            System.out.println("Player wins! Play again?");
            player1.outcome = "won";
            player1.points += 1;
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("scissors") && computersPlay.equals("rock")) {
            System.out.println("Computer wins! Play again?");
            player1.outcome = "lost";
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("rock") && computersPlay.equals("scissors")) {
            System.out.println("Player wins! Play again?");
            player1.outcome = "won";
            player1.points += 1;
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
                System.out.println(player1.points);
                System.out.println("Thanks for playing!");
                break;
        }
    }
}
