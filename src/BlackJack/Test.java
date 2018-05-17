package BlackJack;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter player number: ");
        int n = reader.nextInt();
        reader.close();
        BlackJackGameAutomator automator = new BlackJackGameAutomator(5);
        automator.simulate();
    }
}
