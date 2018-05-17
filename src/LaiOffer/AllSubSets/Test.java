package LaiOffer.AllSubSets;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        AllSubSetsII test = new AllSubSetsII();
        List<String> res = test.subSets("abc");
        for (int i = 0; i< res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
