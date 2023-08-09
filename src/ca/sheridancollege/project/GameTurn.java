package ca.sheridancollege.project;

/**
 * Manages a game turn in the card game.
 *
 * Coordinates the sequence of actions for a game round, including betting, dealing cards,
 * player turns, dealer turn, determining winners, and clearing hands.
 * 
 * @author dancye
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh  Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */

public class GameTurn {

    private final PlayerList players;
    private final Dealer dealer;
    private final Deck deck;

    /**
     * Constructs a game turn with the specified list of players.
     *
     * @param players The list of players participating in the game turn.
     */
    public GameTurn(PlayerList players) {
        this.players = players;
        this.dealer = new Dealer();
        this.deck = new Deck();
    }

      /**
     * Starts and manages the sequence of actions for a game round.
     */
    public void startRound() {
        if (this.players.isEmpty()){
             throw new IllegalArgumentException("No Players!");
        }
        deck.shuffle();
        betPhase();
        dealCards();
        playerTurns();
        dealerTurn();
        determineWinners();
        clearHands();
    }

    private void betPhase() {
        for (Player player : players.getPlayers()) {
            player.bet();
        }
    }

    private void dealCards() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players.getPlayers()) {
                player.getHand().addCard(deck.drawCard());
            }
            dealer.getHand().addCard(deck.drawCard());
        }
    }

    private void playerTurns() {
        for (Player player : players.getPlayers()) {
           player.play(deck);
        }
    }

    private void dealerTurn() {
        dealer.play(deck);
    }

    private void determineWinners() {
        int dealerValue = dealer.getHand().calculateHandValue();
        System.out.println("The Dealer's hand: " + dealer.getHand().getCards());
        System.out.println("Hand value: " + dealerValue + "\n");
        for (Player player : players.getPlayers()) {
            int playerValue = player.getHand().calculateHandValue();
            int betAmount = player.getBet();
            if (playerValue <= 21) {
                if ((dealer.getHand().isBust()) || (playerValue > dealerValue)) {
                    int winnings = 2 * betAmount;
                    player.setMoney(player.getMoney() + winnings);
                    System.out.println(player.getName() + " wins " + winnings + " dollars!");
                } else if (playerValue == dealerValue) {
                    player.setMoney(player.getMoney() + betAmount);
                    System.out.println(player.getName() + " pushes. Bet amount returned.");
                } else {
                    System.out.println(player.getName() + " loses " + betAmount + " dollars.");
                    player.setMoney(player.getMoney() - betAmount);
                    if (player.getMoney() < Player.MIN_BET_AMOUNT){
                        System.out.println("Player: " + player.getName() + " has lost all their money.");
                        players.removePlayer(player);
                    }
                }
            }
        }
    }

    private void clearHands() {
        for (Player player : players.getPlayers()) {
            player.getHand().clear();
        }
        dealer.getHand().clear();
    }
}
