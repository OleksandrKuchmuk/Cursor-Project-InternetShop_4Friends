package view;

public interface Menu {
    void show();

    void exit();

    default void showItems(String[] items) {
        System.out.println("-------------");
<<<<<<< HEAD
        String[] var2 = items;
        int var3 = items.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String item = var2[var4];
            System.out.println(item);
        }

=======
        for (String item : items) {

            System.out.println(item);
        }
>>>>>>> main
        System.out.println("-------------");
    }
}
