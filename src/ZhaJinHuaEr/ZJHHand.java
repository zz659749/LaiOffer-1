package ZhaJinHuaEr;


import poker.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ZJHHand{
    int index;
    Pattern pattern;
    protected final PriorityQueue<Card> data = new PriorityQueue<>(new ZJHComparator());
    protected final List<Card> cards = new ArrayList<>();
    boolean cube;
    boolean sameSuit;
    boolean sequence;
    boolean square;

    public ZJHHand(int index) {
        this.index = index;
    }

    public void addCards(Card[] c) {
        cards.clear();
        for (Card card : c) {
            data.offer(card);
        }
        int size = c.length;
        for (int i = 0; i < size; i++) {
            cards.add(data.poll());
        }
        if (cards.size() < 3) {
            System.out.println("Error! can't get pattern before draw cards.");
        } else {
            sequence = orderCards();
            if (cards.get(0).num() == cards.get(1).num() && cards.get(0).num() == cards.get(2).num()) {
                cube = true;
            }
            if (cards.get(0).suit() == cards.get(1).suit() && cards.get(0).suit() == cards.get(2).suit()) {
                sameSuit = true;
            }
            if (cards.get(0).num() == cards.get(1).num() || cards.get(0).num() == cards.get(2).num() || cards.get(1).num() == cards.get(2).num()) {
                square = true;
            }
        }
        pattern = new Pattern(cube, sameSuit, sequence, square);
    }


    public int getPattern() {
        if (pattern.isBaoZii()) {
            return 0;
        } else if (pattern.isTongHuaShun()) {
            return 1;
        } else if (pattern.isJinHua()) {
            return 2;
        } else if (pattern.isShunZi()) {
            return 3;
        } else if (pattern.isDuiEr()) {
            return 4;
        }
        else return 5;

    }

    public String printPattern() {
        if (pattern.isBaoZii()) {
            return "豹子";
        } else if (pattern.isTongHuaShun()) {
            return "同花顺";
        } else if (pattern.isJinHua()) {
            return "金花";
        } else if (pattern.isShunZi()) {
            return "顺子";
        } else if (pattern.isDuiEr()) {
            return "对儿";
        }
        else return "啥都不是";
    }

    private boolean orderCards() {
        if (cards.get(0).value() == 1) {
            if (cards.get(1).value() == 12 && cards.get(2).value() == 13) {
                return true;
            }
            return false;
        }
        if (cards.get(2).value() - cards.get(1).value() == 1 && cards.get(1).value() - cards.get(0).value() == 1) {
            return true;
        }
        return false;
    }

    public String printCards() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i).suit());
            sb.append(' ');
            sb.append(cards.get(i).num());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
