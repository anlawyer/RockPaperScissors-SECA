import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    // initialize scanner receiving input
    Scanner scanner = new Scanner(System.in);
    // always initialize one player
    Player player1 = new Player();

    public void init() {
        System.out.println("Enter your name to get started:");
        String player1name = scanner.nextLine();
        player1.setName(player1name);
        System.out.println("Welcome, " + player1.getName() + "!");
        System.out.println("Would you like to play against the computer or a friend?");
        System.out.println("Type: computer or friend.");
        this.startGame();
    }

    // call proper play method depending on user's request
    private void startGame() {
        String determinePlayer = scanner.nextLine();
        try {
            if (determinePlayer.toLowerCase().equals("computer")) {
                Player player2 = new Player();
                this.computerPlayer(player2);
            } else if (determinePlayer.toLowerCase().equals("friend")) {
                Player player2 = new Player();
                System.out.println("Have your friend type their name:");
                String player2name = scanner.nextLine();
                player2.setName(player2name);
                System.out.println("Welcome, " + player2.getName() + "!");
                this.twoPlayers(player2);
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

    private void computerPlayer(Player player2) {
        player2.setName("Computer");
        System.out.println(player1.getName() + ", your turn. Enter your play! Type: rock, paper, or scissors.");

        String player1play = scanner.nextLine();
        try {
            if (("rock").equals(player1play.toLowerCase()) || ("paper").equals(player1play.toLowerCase()) || ("scissors").equals(player1play.toLowerCase())) {
                player1.setPlay(player1play.toLowerCase());
                System.out.println("You played: " + player1.getPlay());

                // generate computer's play
                Random randomPlay = new Random();
                int computersRand = randomPlay.nextInt(3);
                if (computersRand == 0) {
                    player2.setPlay("rock");
                } else if (computersRand == 1) {
                    player2.setPlay("paper");
                } else {
                    player2.setPlay("scissors");
                }
                System.out.println(player2.getName() + " played: " + player2.getPlay());

                // set variable to response from user from round() method
                String playAgain = this.round(player1, player2);

                try {
                    if (playAgain.equals("tied")) {
                        this.computerPlayer(player2);
                    } else if (playAgain.equals("yes")) {
                        System.out.println(player1.getName() + ", you have " + player1.getScore() + " points.");
                        System.out.println(player2.getName() + " has " + player2.getScore() + " points.");
                        this.computerPlayer(player2);
                    } else if (playAgain.equals("no")) {
                        System.out.println(player1.getName() + ", you have " + player1.score + " points.");
                        System.out.println(player2.getName() + " has " + player2.getScore() + " points.");
                        System.out.println("Thanks for playing!");
                    } else {
                        throw new InputMismatchException();
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Could not determine input, restarting game.");
                    this.init();
                }
            }
            else {
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException e) {
            // handle improper input
            System.out.println("Please enter: rock, paper, or scissors.");
            this.computerPlayer(player2);
        }
    }

    private void twoPlayers(Player player2) {
        System.out.println(player1.getName() + ", your turn. Enter your play! Type: rock, paper, or scissors.");
        String player1play = scanner.nextLine();
        try {
            if (("rock").equals(player1play.toLowerCase()) || ("paper").equals(player1play.toLowerCase()) || ("scissors").equals(player1play.toLowerCase())) {
                player1.setPlay(player1play.toLowerCase());
                System.out.println("You played: " + player1.getPlay());

                System.out.println(player2.getName() + ", your turn. Enter your play! Type: rock, paper, or scissors.");
                String player2play = scanner.nextLine();
                try {
                    if (("rock").equals(player2play.toLowerCase()) || ("paper").equals(player2play.toLowerCase()) || ("scissors").equals(player2play.toLowerCase())) {
                        player2.setPlay(player2play.toLowerCase());
                        System.out.println(player2.getName() + " played: " + player2.getPlay());

                        // set variable to response from user from round() method
                        String playAgain = this.round(player1, player2);

                        try {
                            if (playAgain.equals("tied")) {
                                this.twoPlayers(player2);
                            } else if (playAgain.equals("yes")) {
                                System.out.println(player1.getName() + ", you have " + player1.getScore() + " points.");
                                System.out.println(player2.getName() + ", you have " + player2.getScore() + " points.");
                                this.twoPlayers(player2);
                            } else if (playAgain.equals("no")) {
                                System.out.println(player1.getName() + ", you have " + player1.getScore() + " points.");
                                System.out.println(player2.getName() + ", you have " + player2.getScore() + " points.");
                                System.out.println("Thanks for playing!");
                            } else {
                                throw new InputMismatchException();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Could not determine input, restarting game.");
                            this.init();
                        }
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    // handle improper input
                    System.out.println("Please enter: rock, paper, or scissors.");
                    this.twoPlayers(player2);
                }
            } else {
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException e) {
            // handle improper input
            System.out.println("Please enter: rock, paper, or scissors.");
            this.twoPlayers(player2);
        }
    }

    private String round(Player player1, Player player2) {
        // default to another round is no, scores are 0
        String playAgain = "no";
        int player1score = 0;
        int player2score = 0;
        // conditional statements to determine winner of each round and update score/outcomes
        if (player2.getPlay().equals(player1.getPlay())) {
            System.out.println("Tied game! Play again.");
            playAgain = "tied";
        } else if (player1.getPlay().equals("rock") && player2.getPlay().equals("paper")) {
            System.out.println(player2.getName() + " wins! Play again?");
            player1.setOutcome("lost");
            player2.setOutcome("won");
            player2score++;
            player2.setScore(player2score);
            playAgain = scanner.nextLine();
        } else if (player1.getPlay().equals("paper") && player2.getPlay().equals("rock")) {
            System.out.println(player1.getName() + " wins! Play again?");
            player1.setOutcome("won");
            player2.setOutcome("lost");
            player1score++;
            player1.setScore(player1score);
            playAgain = scanner.nextLine();
        } else if (player1.getPlay().equals("paper") && player2.getPlay().equals("scissors")) {
            System.out.println(player2.getName() + " wins! Play again?");
            player1.setOutcome("lost");
            player2.setOutcome("won");
            player2score++;
            player2.setScore(player2score);
            playAgain = scanner.nextLine();
        } else if (player1.getPlay().equals("scissors") && player2.getPlay().equals("paper")) {
            System.out.println(player1.getName() + " wins! Play again?");
            player1.setOutcome("won");
            player2.setOutcome("lost");
            player1score++;
            player1.setScore(player1score);
            playAgain = scanner.nextLine();
        } else if (player1.getPlay().equals("scissors") && player2.getPlay().equals("rock")) {
            System.out.println(player2.getName() + " wins! Play again?");
            player1.setOutcome("lost");
            player2.setOutcome("won");
            player2score++;
            player2.setScore(player2score);
            playAgain = scanner.nextLine();
        } else if (player1.getPlay().equals("rock") && player2.getPlay().equals("scissors")) {
            System.out.println(player1.getName() + " wins! Play again?");
            player1.setOutcome("won");
            player2.setOutcome("lost");
            player1score++;
            player1.setScore(player1score);
            playAgain = scanner.nextLine();
        }
        return playAgain.toLowerCase();
    }
}
