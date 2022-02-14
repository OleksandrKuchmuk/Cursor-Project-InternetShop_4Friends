package view;

public interface Menu {

    void show();

    default void showItems(String[] items) {
        System.out.println("-".repeat(15));
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("-".repeat(15));
    }
}