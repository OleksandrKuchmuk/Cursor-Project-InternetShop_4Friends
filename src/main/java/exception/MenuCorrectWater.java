package exception;

import java.util.Scanner;

public class MenuCorrectWater {

    public static int menuCorrectWater(int i) {

        int choice = 0;
        boolean exit = true;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <=i) {
                exit = false;
                } else {
                    System.out.println("Incorrect water, Number not in between 0 - "+i);
                }
            } else {
                System.out.println("Incorrect water, see the number from 0 -"+i);
            }
        }
        return choice;


    }

}
