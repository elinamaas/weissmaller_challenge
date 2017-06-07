package de.weissmaller;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class BasketServiceTest {

    @Test
    public void productAmountTest(){
        Basket basket = EntityFactory.initializeBasket();
        BasketService basketService = new BasketService();
        HashMap<Product, Integer> basketAmount = basketService.productAmount(basket);
        assertThat(basketAmount.get(Product.PAPAYA), is(2));
        assertThat(basketAmount.get(Product.APPLE), is(3));
        assertThat(basketAmount.get(Product.BANANA), is(1));
        assertThat(basketAmount.get(Product.GARLIC), is(1 ));

    }
}
