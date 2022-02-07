package dao.impl;

import dao.ProductDao;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao  {
   public HashMap<String, Object> productMap;

    public ProductDaoImpl() throws IOException, ClassNotFoundException {
//        this.productMap = new HashMap<>();
//        add(new Product("Apple", 1.0,10));
//        add(new Product("Egg", 1.5, 50));
//        HashMap<String, Object> fileObj = new HashMap<String, Object>();
//
//        ArrayList<String> cols = new ArrayList<String>();
//        cols.add("a");
//        cols.add("b");
//        cols.add("c");
//        fileObj.put("myList", cols);
//        {
//            File file = new File("ProductList");
//            FileOutputStream f = new FileOutputStream(file);
//            ObjectOutputStream s = new ObjectOutputStream(f);
//            s.writeObject(productMap);
//            s.close();
////            System.out.println(productMap.toString());
//        }
//        File file = new File("ProductList");
//        FileInputStream f = new FileInputStream(file);
//        ObjectInputStream s = new ObjectInputStream(f);
//        HashMap<String, Object> fileObj2 = (HashMap<String, Object>) s.readObject();
//        s.close();
//        System.out.println(fileObj2.toString());
    }

    public void setProductMap() throws IOException {
//        productMap = new HashMap<String, Object>();
//        productMap.put("Apple", new Product("Apple",1.0,10));
//        productMap.put("Egg", new Product("Egg", 1.5, 50));
//        return this.productMap;
//    }

//    public void addFileWithProducts() throws IOException, ClassNotFoundException {
//        FileReader readFromFile = new FileReader("ProductList");
//        FileWriter writeToFile = new FileWriter("ProductList.txt");

        ArrayList<Product> productArrayList = new ArrayList<Product>();
        productArrayList.add(new Product("Apple",1.0,10));
        productArrayList.add(new Product("Egg", 1.5, 50));

        // write to file

        try{
            FileOutputStream writeData = new FileOutputStream("ProductData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(productArrayList);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
//            read from file
        try{
            FileInputStream readData = new FileInputStream("ProductData1.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Product> people2 = (ArrayList<Product>) readStream.readObject();
            readStream.close();
            System.out.println(people2.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }



    }



    @Override
    public Optional<Product> add(Product product) throws IOException {

        return Optional.empty();
    }

    @Override
    public Optional<Product> getByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> update(String name, Product newProduct) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> delete(String name) {
        return Optional.empty();
    }

    @Override
    public Map<String, Product> getAllProducts() throws IOException, ClassNotFoundException {
        File file = new File("ProductList");
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream s = new ObjectInputStream(f);
        HashMap<String, Object> fileObj2 = (HashMap<String, Object>) s.readObject();
        s.close();
        System.out.println(fileObj2.toString());
        return null;
    }
}
