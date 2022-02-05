package view;

public interface Menu {
    void show();

    void exit();

    default void showItems(String[] items) {
        System.out.println("-------------");
        String[] var2 = items;
        int var3 = items.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String item = var2[var4];
            System.out.println(item);
        }

        System.out.println("-------------");
    }
}
