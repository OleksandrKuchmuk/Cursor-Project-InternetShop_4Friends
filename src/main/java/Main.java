import service.UserService;
import service.impl.UserServiceImpl;
import view.impl.LoginMenu;

public class Main {
    public static void main(String[] args) {
        new LoginMenu(new UserServiceImpl()).show();


    }
}