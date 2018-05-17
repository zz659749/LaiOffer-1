package ZhaJinHuaEr;

import java.util.Comparator;

public class OrderComparator implements Comparator<ZJHHand> {
    @Override
    public int compare(ZJHHand o1, ZJHHand o2) {
        int[] diff = new int[3];
        int[] suitDiff = new int[3];
        for (int i = 0; i < 3; i++) {
            diff[i] = o1.cards.get(i).value() - o2.cards.get(i).value();
            suitDiff[i] = o1.cards.get(i).suitValue() - o2.cards.get(i).suitValue();
        }

        if (o1.getPattern() == 0) {
            //豹子
            if (o1.cards.get(0).value() == 1) {
                return 1;
            } else if (o2.cards.get(0).value() == 1) {
                return -1;
            } else {
                return diff[0];
            }
        } else if (o1.getPattern() == 1) {
            //同花顺
            if (o1.cards.get(0).value() == 1 && o2.cards.get(0).value() == 1) {
                return suitDiff[0];
            } else if (o1.cards.get(0).value() == 1) {
                return 1;
            } else if (o2.cards.get(0).value() == 1) {
                return -1;
            } else {
                if (o1.cards.get(0).value() == o2.cards.get(0).value()) {
                    return suitDiff[0];
                } else {
                    return diff[0];
                }
            }

        } else if (o1.getPattern() == 2) {
            //金花
            if (o1.cards.get(0).value() == 1 && o2.cards.get(0).value() == 1) {
                //都是顶金
                if (diff[2] == 0) {
                    if (diff[1] == 0) {
                        return suitDiff[0];
                    }
                    return diff[2];
                }
                return diff[1];
            } else {
                //非顶金
                if (diff[2] == 0) {
                    if (diff[1] == 0) {
                        if (diff[0] == 0) {
                            return suitDiff[0];
                        }
                        return diff[0];
                    }
                    return diff[1];
                }
                return diff[2];
            }

        } else if (o1.getPattern() == 3) {
            //顺子
            if (o1.cards.get(0).value() == 1 && o1.cards.get(0).value() == 1) {
                //顶顺
                return suitDiff[0];
            }
            if (o1.cards.get(0).value() == 1) {
                return 1;
            }
            if (o2.cards.get(0).value() == 1) {
                return -1;
            }
            if (diff[2] == 0) {
                if (diff[1] == 0) {
                    if (diff[0] == 0) {
                        return suitDiff[2];
                    }
                    return diff[0];
                }
                return diff[1];
            }
            return diff[2];
        } else if (o1.getPattern() == 4){
            //对儿
            if (o1.cards.get(0).value() == 1 && o1.cards.get(0).value() == 1) {
                //顶对儿
                if (diff[2] == 0) {
                    return suitDiff[1];
                }
                return diff[2];
            }
            if (o1.cards.get(0).value() == 1) {
                return 1;
            }
            if (o2.cards.get(0).value() == 1) {
                return -1;
            }
            if (diff[2] == 0) {
                if (diff[0] == 0) {
                    return suitDiff[2];
                }
                return diff[0];
            }
            return diff[2];
        } else {
            if (o1.cards.get(0).value() == 1 && o1.cards.get(0).value() == 1) {
                //顶普通
                if (diff[2] == 0) {
                    if (diff[1] == 0) {
                        return suitDiff[0];
                    }
                    return diff[1];
                }
                return diff[2];
            }
            if (o1.cards.get(0).value() == 1) {
                return 1;
            }
            if (o2.cards.get(0).value() == 1) {
                return -1;
            }
            //真.普通
            if (diff[2] == 0) {
                if (diff[1] == 0) {
                    if (diff[0] == 0) {
                        return suitDiff[2];
                    }
                    return diff[0];
                }
                return diff[1];
            }
            return diff[2];
        }
    }
}
