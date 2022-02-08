import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;
import view.impl.LoginMenu;

public class Main {
    public static void main(String[] args) {
//        new LoginMenu(new UserServiceImpl()).show();

//        new LoginMenu().show();
        new LoginMenu(new OrderServiceImpl(), new UserServiceImpl(), new ProductServiceImpl()).show();


//        productDaoImpl.addFileWithProducts();
//        productDaoImpl.;
//        productDaoImpl.getAllProducts();

//        Assert.assertEquals(fileObj.hashCode(), fileObj2.hashCode());
//        Assert.assertEquals(fileObj.toString(), fileObj2.toString());
//        Assert.assertTrue(fileObj.equals(fileObj2));


    }
}