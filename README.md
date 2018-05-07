# Rock Paper Scissors

Did you know there's a world championship for Rock Paper Scissors? The simple two-player game has a long history and has many variations, yet it remains one of the staples for decision-making in groups. Can't decide who's up? "Rock, Paper, Scissors, Shoot."

With this Java command-line interpretation of the classic game, you can try your luck playing against the computer, or play against your friend! The computer's move is entirely random, so it will take some luck for you to win. Playing your friend, on the other hand... you might want to take turns going first. Clone this repo and open in your favorite Java editor/compiler, then run `Main` to play!

The goal of this project was to get more comfortable with the fundamentals of Object Oriented Programming. The `Game` class holds the command line prompts for beginning and playing the game, as well as the logic for determining the winner of any given round against the computer or a friend. The `Player` class holds the variables associated with each player that is instantiated during game play. 

The logic is simple and straight-forward: select whether you want to play the computer or a friend. You, player 1, play a round by entering your move and player 2 will play their move (player 2 is either the computer or your friend, depending on your initial selection). The winner is declared, and you will be asked if you'd like to play again, to which you can respond "yes" or "no". The games continue until you say "no", then you can start over with a new set of rounds!
