import service.impl.UserServiceImpl;
import view.impl.LoginMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new LoginMenu(new UserServiceImpl()).show();

//        new LoginMenu().show();
            new LoginMenu(new UserServiceImpl()).show();


//        productDaoImpl.addFileWithProducts();
//        productDaoImpl.;
//        productDaoImpl.getAllProducts();

//        Assert.assertEquals(fileObj.hashCode(), fileObj2.hashCode());
//        Assert.assertEquals(fileObj.toString(), fileObj2.toString());
//        Assert.assertTrue(fileObj.equals(fileObj2));





    }
}