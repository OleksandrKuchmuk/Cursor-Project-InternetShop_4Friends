package exception;

import java.util.Scanner;

public class MenuNumberCorrectInputException {

    public static int menuNumberCorrectInputException(int i) {

        int choice = 0;
        boolean exit = true;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <=i) {
                exit = false;
                } else {
                    System.out.println("Incorrect input, number not in between 0 - "+i);
                }
            } else {
                System.out.println("Incorrect input, number not in between 0 - "+i);
            }
        }
        return choice;
    }
}
