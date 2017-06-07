package de.weissmaller;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Product> productList;

    public Basket() {
        this.productList = new ArrayList<>();

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void addProduct(String productName){
        productName = productName.toLowerCase();
        try {
            this.addProduct(Product.getByName(productName));
        }catch (IllegalArgumentException ex){
            System.out.println("There is no " + productName + " Maybe you misspelled it?");
        }
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
