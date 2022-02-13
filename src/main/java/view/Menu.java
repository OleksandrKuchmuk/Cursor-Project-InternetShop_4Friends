package view;

import java.io.IOException;

public interface Menu {
    void show() throws IOException, ClassNotFoundException;

    void exit() throws IOException, ClassNotFoundException;

    default void showItems(String[] items) {
        System.out.println("-------------");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("-------------");
    }



}
