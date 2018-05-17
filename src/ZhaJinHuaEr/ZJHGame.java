package ZhaJinHuaEr;

import poker.Card;
import poker.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ZJHGame {

    private final ZJHHand[] hands;
    private Deck deck;

    public ZJHGame(int numOfPlayers) {
        hands = new ZJHHand[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            hands[i] = new ZJHHand(i + 1);
        }
    }

    void initializeDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    boolean dealInitial() {
        for (ZJHHand hand : hands) {
            Card[] cards = deck.dealHand(3);
            if (cards == null) {
                return false;
            }

            hand.addCards(cards);
        }
        return true;
    }

    List<ZJHHand> getWinner() {
        List<ZJHHand> order = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            PriorityQueue<ZJHHand> orderHeap = new PriorityQueue<>(new OrderComparator());
            for (ZJHHand hand : hands) {
                if (hand.getPattern() == i) {
                    orderHeap.offer(hand);
                }
            }
            int size = orderHeap.size();
            for (int j = 0; j < size; j++) {
                order.add(orderHeap.poll());
            }
        }
        return order;
    }


    void printHandsAndScore(List<ZJHHand> order) {
        for (int i = 0; i < order.size(); i++) {
            for (int j = 0; j < order.size(); j++) {
                if (order.get(j).index == i + 1) {
                    ZJHHand currPlayer = order.get(j);
                    System.out.println("Player" + currPlayer.index + ": " + currPlayer.printCards() + " (" + currPlayer.printPattern() + ")");
                }
            }
        }
        System.out.println();
        System.out.println("Winner is: Player " + order.get(0).index + " !");
    }

    public void simulate(Scanner reader) {
        System.out.println("== Game Start ==");
        initializeDeck();
        boolean success;
        char c = 'n';
        int count = 0;
        while (true) {
            success = dealInitial();
            if (success) {
                count++;
                System.out.println("-- Round " + count + " Start --");
                List<ZJHHand> result = getWinner();
                printHandsAndScore(result);
                System.out.println("-- Round " + count + " End --");
                System.out.println("Another round? (Y/N): ");
                c = reader.next().charAt(0);
                if (c == 'n' || c == 'N') {
                    System.out.println("== Game End ==");
                    break;
                }
            } else {
                System.out.println("Run out of cards. Shuffle the deck.");
                initializeDeck();
            }
        }
    }

}
