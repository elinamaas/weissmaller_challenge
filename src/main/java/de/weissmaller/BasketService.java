package de.weissmaller;

import java.util.HashMap;

public class BasketService {
    public  HashMap<Product, Integer> productAmount(Basket basket) {
        HashMap<Product, Integer> productAmount = new HashMap<>();
        basket.getProductList().forEach(product ->
                productAmount.put(product, (productAmount.containsKey(product) ? productAmount.get(product) : 0) + 1));
        return productAmount;

    }
}
