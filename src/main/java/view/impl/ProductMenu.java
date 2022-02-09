package view.impl;

import view.Menu;

public class ProductMenu implements Menu {

    @Override
    public void show() {
        System.out.println("Список продуктів");
    }

    @Override
    public void exit() {
    }
}
