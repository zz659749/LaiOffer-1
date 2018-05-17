package LaiOffer.String;
import java.util.*;

public class DetermineSubstring {
    public int strstr(String large, String small) {
        // Write your solution here
        if (small == "") {
            return 0;
        }
        char[] set = large.toCharArray();
        char[] target = small.toCharArray();
        for (int j = 0; j < large.length() - small.length(); j++) {
            if (set[j] == target[0]) {
                int i = 0, start = j;
                while (i < target.length) {
                    if (set[start++] != target[i++]) {
                        break;
                    }
                }
                if (i == target.length) {
                    return j;
                }
            }
        }
        return -1;
    }
}
