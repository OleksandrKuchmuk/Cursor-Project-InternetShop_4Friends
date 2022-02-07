
import service.UserService;
import service.impl.UserServiceImpl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import view.impl.LoginMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new LoginMenu(new UserServiceImpl()).show();

//        new LoginMenu().show();
            new LoginMenu(new UserServiceImpl()).show();
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        productDaoImpl.setProductMap();
//        productDaoImpl.addFileWithProducts();
//        productDaoImpl.;
//        productDaoImpl.getAllProducts();

//        Assert.assertEquals(fileObj.hashCode(), fileObj2.hashCode());
//        Assert.assertEquals(fileObj.toString(), fileObj2.toString());
//        Assert.assertTrue(fileObj.equals(fileObj2));





    }
}