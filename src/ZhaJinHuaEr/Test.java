package ZhaJinHuaEr;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter player number: ");
        int n = reader.nextInt();

        ZJHGame automator = new ZJHGame(n);
        automator.simulate(reader);
        reader.close();
    }
}
