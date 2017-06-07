package de.weissmaller;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ProductTest {

    @Test
    public void getByNameSingularTest() {
        String name = "apple";
        Product product = Product.getByName(name);
        assertThat(product, is(Product.APPLE));
    }

    @Test
    public void getByNamePluralTest() {
        String name = "apples";
        Product product = Product.getByName(name);
        assertThat(product, is(Product.APPLE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByNameFail() {

        String name = "aples";
        Product.getByName(name);
    }
}
