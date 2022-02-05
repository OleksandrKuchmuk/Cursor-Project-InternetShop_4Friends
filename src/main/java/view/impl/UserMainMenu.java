package view.impl;


import view.Menu;

public class UserMainMenu implements Menu {
    LoginMenu loginMenu;
    @Override
    public void show() {
        System.out.println("AHhaaa!!");
    }

    @Override
    public void exit() {
        this.loginMenu.show();
    }
}
