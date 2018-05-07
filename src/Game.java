import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    // initialize scanner receiving input
    // always initialize one player
    Scanner scanner = new Scanner(System.in);
    Player player1 = new Player();

    Game() {
        // game constructor: intro to game, call startGame method
        System.out.println("Enter your name to get started:");
        player1.name = scanner.nextLine();
        System.out.println("Welcome, " + player1.name + "!");
        System.out.println("Would you like to play against the computer or a friend?");
        System.out.println("Type: computer or friend.");
        this.startGame();
    }

    // call proper play method depending on user's request
    public void startGame () {
        String determinePlayer = scanner.nextLine();
        try {
            if (determinePlayer.toLowerCase().equals("computer")) {
                this.computerPlayer();
            } else if (determinePlayer.toLowerCase().equals("friend")) {
                this.twoPlayers();
            } else if (determinePlayer.toLowerCase().equals("exit")) {
                System.out.println("Thanks for playing!");
            }
            else {
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException e) {
            // handle improper input
            System.out.println("Would you like to play against the computer, a friend, or exit?");
            this.startGame();
        }
    }

    public void computerPlayer () {
        Player player2 = new Player();
        player2.name = "Computer";
        System.out.println(player1.name + ", your turn. Enter your play! Type: rock, paper, or scissors.");

        String players1play = scanner.nextLine();
        try {
            if (players1play.toLowerCase().equals("rock") || players1play.toLowerCase().equals("paper") || players1play.toLowerCase().equals("scissors")) {
                player1.play = players1play.toLowerCase();
                System.out.println("You played: " + player1.play);

                // generate computer's play
                Random randomPlay = new Random();
                int computersRand = randomPlay.nextInt(3);
                if (computersRand == 0) {
                    player2.play = "rock";
                } else if (computersRand == 1) {
                    player2.play = "paper";
                } else {
                    player2.play = "scissors";
                }
                System.out.println(player2.name + " played: " + player2.play);

                String playAgain = this.round(player1, player2);

                try {
                    if (playAgain.equals("yes")) {
                        System.out.println(player1.name + ", you have " + player1.score + " points.");
                        this.computerPlayer();
                    } else if (playAgain.equals("tied")) {
                        this.computerPlayer();
                    } else if (playAgain.equals("no")) {
                        System.out.println(player1.name + ", you have " + player1.score + " points.");
                        System.out.println("Thanks for playing!");
                    } else {
                        throw new InputMismatchException();
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter yes or no.");
                }
            }
            else {
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException e) {
            // handle improper input
            System.out.println("Please enter: rock, paper, or scissors.");
            this.computerPlayer();
        }
    }

    public void twoPlayers () {
        Player player2 = new Player();
        System.out.println("Have your friend type their name:");
        player2.name = scanner.nextLine();
        System.out.println("Welcome, " + player2.name + "!");

        System.out.println(player1.name + ", your turn. Enter your play! Type: rock, paper, or scissors.");
        String player1play = scanner.nextLine();
        try {
            if (player1play.toLowerCase().equals("rock") || player1play.toLowerCase().equals("paper") || player1play.toLowerCase().equals("scissors")) {
                player1.play = player1play.toLowerCase();
                System.out.println("You played: " + player1.play);

                System.out.println(player2.name + ", your turn. Enter your play! Type: rock, paper, or scissors.");
                String player2play = scanner.nextLine();
                try {
                    if (player1play.toLowerCase().equals("rock") || player1play.toLowerCase().equals("paper") || player1play.toLowerCase().equals("scissors")) {
                        player2.play = player2play.toLowerCase();
                        System.out.println(player2.name + " played: " + player2.play);

                        String playAgain = this.round(player1, player2);

                        try {
                            if (playAgain.equals("yes")) {
                                System.out.println(player1.name + ", you have " + player1.score + " points.");
                                System.out.println(player2.name + ", you have " + player2.score + " points.");
                                this.twoPlayers();
                            } else if (playAgain.equals("tied")) {
                                this.twoPlayers();
                            } else if (playAgain.equals("no")) {
                                System.out.println(player1.name + ", you have " + player1.score + " points.");
                                System.out.println(player2.name + ", you have " + player2.score + " points.");
                                System.out.println("Thanks for playing!");
                            } else {
                                throw new InputMismatchException();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Please enter yes or no.");
                        }
                    }
                } catch (InputMismatchException e) {
                    // handle improper input
                    System.out.println("Please enter: rock, paper, or scissors.");
                    this.computerPlayer();
                }
            }
        }
        catch (InputMismatchException e) {
            // handle improper input
            System.out.println("Please enter: rock, paper, or scissors.");
            this.computerPlayer();
        }
    }

    public String round (Player player1, Player player2) {
        // default to another round is no
        String playAgain = "no";
        // conditional statements to determine winner of each round
        if (player2.play.equals(player1.play)) {
            System.out.println("Tied game! Play again.");
            playAgain = "tied";
        } else if (player1.play.equals("rock") && player2.play.equals("paper")) {
            System.out.println(player2.name + " wins! Play again?");
            player1.outcome = "lost";
            player2.outcome = "won";
            player2.score += 1;
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("paper") && player2.play.equals("rock")) {
            System.out.println(player1.name + " wins! Play again?");
            player1.outcome = "won";
            player2.outcome = "lost";
            player1.score += 1;
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("paper") && player2.play.equals("scissors")) {
            System.out.println(player2.name + " wins! Play again?");
            player1.outcome = "lost";
            player2.outcome = "won";
            player2.score += 1;
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("scissors") && player2.play.equals("paper")) {
            System.out.println(player1.name + " wins! Play again?");
            player1.outcome = "won";
            player2.outcome = "lost";
            player1.score += 1;
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("scissors") && player2.play.equals("rock")) {
            System.out.println(player2.name + " wins! Play again?");
            player1.outcome = "lost";
            player2.outcome = "won";
            player2.score += 1;
            playAgain = scanner.nextLine();
        } else if (player1.play.equals("rock") && player2.play.equals("scissors")) {
            System.out.println(player1.name + " wins! Play again?");
            player1.outcome = "won";
            player2.outcome = "lost";
            player1.score += 1;
            playAgain = scanner.nextLine();
        }
        return playAgain.toLowerCase();
    }
}
