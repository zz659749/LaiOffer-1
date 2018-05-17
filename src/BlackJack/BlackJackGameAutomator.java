package BlackJack;

import poker.Card;
import poker.Deck;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGameAutomator {
    private Deck deck;
    private BlackJackHand[] hands;
    private static final int HIT_UNTIL = 16;

    public BlackJackGameAutomator(int numPlayers) {
        hands = new BlackJackHand[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            hands[i] = new BlackJackHand();
        }
    }

    void initializeDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    boolean dealInitial() {
        for (BlackJackHand hand : hands) {
            Card[] cards = deck.dealHand(2);
            if (cards == null) {
                return false;
            }
            hand.addCards(cards);
        }
        return true;
    }

    List<Integer> getBlackJacks() {
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].isBlackJack()) {
                winners.add(i);
            }
        }
        return winners;
    }

    boolean playHand(BlackJackHand hand) {
        while (hand.score() < HIT_UNTIL) {
            Card card  = deck.dealCard();
            if (card == null) {
                return false;
            }
            hand.addCards(new Card[]{card});
        }
        return true;
    }

    boolean playAllHands() {
        for (BlackJackHand hand : hands) {
            if (!playHand(hand)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> getWinners() {
        List<Integer> winners = new ArrayList<>();
        int winningScore = 0;
        for (int i = 0; i < hands.length; i++) {
            BlackJackHand hand = hands[i];
            if (!hand.busted()) {
                if (hand.score() > winningScore) {
                    winningScore = hand.score();
                    winners.clear();
                    winners.add(i);
                } else if (hand.score() == winningScore) {
                    winners.add(i);
                }
            }
        }
        return winners;
    }

    void printHandsAndScore() {
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Hand" + i + "(" + hands[i].printCards() + "):");
            hands[i].print();
            System.out.println();
        }
    }

    public void simulate() {
        initializeDeck();

        boolean success = dealInitial();
        if (!success) {
            System.out.println("Error. Out of cards.");
        } else {
            System.out.println("-- Initial --");
            printHandsAndScore();
            List<Integer> blackJacks = getBlackJacks();
            if (blackJacks.size() > 0) {
                System.out.print("Blackjack at Hand");
                for (int i : blackJacks) {
                    System.out.print(i + " ");
                }
                System.out.println("\ndone.");
            } else {
                success = playAllHands();
                if (!success) {
                    System.out.println("Error.Out of cards.");
                } else {
                    System.out.println("\n-- Completed Game --");
                    printHandsAndScore();
                    List<Integer> winners = getWinners();
                    if (winners.size() > 0) {
                        System.out.print("Winners: ");
                        for (int i : winners) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }
}
