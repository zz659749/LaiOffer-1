package LaiOffer.String;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        char[] str = input.toCharArray();
        int i = 0, j = 0;
        while (j < str.length) {
            if (str[j] == ' ') {
                if (i == 0) {
                    j++;
                    continue;
                }
                if (str[i - 1] != ' ') {
                    str[i++] = str[j++];
                }
                j++;
            } else {
                str[i++] = str[j++];
            }
        }
        if (i > 0 || str[i - 1] == ' ') {
            return new String(str, 0, i - 1);
        }
        return new String(str, 0, i);
    }
}
