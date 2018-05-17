package ZhaJinHuaEr;

import poker.Card;

import java.util.Comparator;

public class ZJHComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1.value() == o2.value()) {
            return o1.suitValue() - o2.suitValue();
        } else {
            return o1.value() - o2.value();
        }
    }
}
