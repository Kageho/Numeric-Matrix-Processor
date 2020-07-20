package processor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // just infinity loop, it'll stop when user input 0
        while (true) {
            boolean move = Menu.chooseAction();
            if (!move) {
                break;
            }
        }
    }
}
