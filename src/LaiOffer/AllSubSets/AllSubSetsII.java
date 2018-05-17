package LaiOffer.AllSubSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubSetsII {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] arrayChar = set.toCharArray();
        Arrays.sort(arrayChar);
        StringBuilder sb = new StringBuilder();
        helper(arrayChar, 0, res, sb);
        return res;
    }

    private void helper(char[] set, int index, List<String> res, StringBuilder sb) {
        res.add(sb.toString());
        for (int i = index; i < set.length; i++) {
            if (i != 0 && i != index && set[i] == set[i - 1]) {
                continue;
            }
            sb.append(set[i]);
            helper(set, index + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
