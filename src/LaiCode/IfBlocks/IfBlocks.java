package LaiCode.IfBlocks;

import java.util.*;


public class IfBlocks {
    public void getAllIfBlocks(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            printIfBlocks(result);
        }
        getAllBlocks(n, 0, 0, new StringBuilder(), result);

        printIfBlocks(result);
    }


    public void getAllBlocks(int n, int left, int right, StringBuilder pre, List<String> result) {
        if (2 * n == left + right) {
            result.add(format(pre));
            return;
        }

        if (left > right) {
            pre.append(')');
            getAllBlocks(n, left, right + 1, pre, result);
            pre.deleteCharAt(pre.length() - 1);
        }

        if (left < n) {
            pre.append('(');
            getAllBlocks(n, left + 1, right, pre, result);
            pre.deleteCharAt(pre.length() - 1);
        }
    }


    // using format to decouple the logic
    private String format(StringBuilder input) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                appendSpace(result, count);
                result.append("if {\n");
                count+=2;
            } else {
                count-=2;
                appendSpace(result, count);
                result.append("}\n");
            }
        }
        return result.toString();
    }

    private void appendSpace(StringBuilder res, int count) {
        for (int i = 0; i < count; i++) {
            res.append(' ');
        }
    }

    private void printIfBlocks(List<String> res) {
        for (String str : res) {
            System.out.println(str);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        IfBlocks test = new IfBlocks();
        test.getAllIfBlocks(3);
    }
}
