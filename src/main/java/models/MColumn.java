package models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MColumn {
    private int id;
    private HashSet<Product> products;
    private int capacity;


    public MColumn(int id) {
        this.id = id;
        this.products = new HashSet<>();
    }

    public MColumn(int id,int capacity) {
        this.id = id;
        this.products = new HashSet<>();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashSet<Product> getProducts() {
        return products;
    }

    public void setProducts(HashSet<Product> products) {
        this.products = products;
    }

    public boolean insertProduct(Product product){

        if (!isFull()&&sameProduct(product)){
            products.add(product);
            return true;
        }
        return false;
    }

    private boolean sameProduct(Product product) {
        if(products.size()==0)
            return true;

        Product first=null;
        for (Product tepm:
             products) {
            first=tepm;
            break;
        }
        if (product.getSerial()==first.getSerial())
            return true;
        return false;
    }

    public Product findProduct(Product product){
        Product temp=null;
        for (Product product1 :
                products) {
            temp = product1;
            break;
        }
        return product.getSerial()==temp.getSerial()?temp:null;
    }

    public Product findProduct(int id){
        Product temp=null;
        for (Product product1 :
                products) {
            temp = product1;
            break;
        }
        return (id==temp.getSerial())?temp:null;
    }
    public Product getFirstIndex(){
        Product temp=null;
        for (Product product :
                products) {
            temp = product;
            break;
        }
        return temp;
    }
    public boolean isFull(){
        return (capacity <= products.size());
    }
}
