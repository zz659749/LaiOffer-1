package LaiCode.StringAbbreviationMatching;

public class SAM {
    public boolean match(String input, String pattern) {
        // Write your solution here
        return matchHelper(input, 0, pattern, 0);
    }

    private boolean matchHelper(String input, int inputStart, String pattern, int patternStart) {
        //base case
        if (inputStart == input.length() && patternStart == pattern.length()) {
            return true;
        }
        if (inputStart >= input.length() || patternStart >= pattern.length()) {
            return false;
        }
        //case1: if is letter
        if (pattern.charAt(patternStart) < '0' || pattern.charAt(patternStart) > '9') {
            if (input.charAt(inputStart) == pattern.charAt(patternStart)) {
                return matchHelper(input, inputStart + 1, pattern, patternStart + 1);
            } else {
                return false;
            }
        }
        //case2: if is digit
        int count = 0;
        while (patternStart < pattern.length() && pattern.charAt(patternStart) <= '9' && input.charAt(inputStart) >= '0') {
            count = count * 10 + pattern.charAt(patternStart) - '0';
            patternStart ++;
        }
        return matchHelper(input, inputStart + count, pattern, patternStart);
    }

    public static void main(String[] args) {
        SAM test = new SAM();
        System.out.println(test.match("laioffercom", "l10"));

    }
}


