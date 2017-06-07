package de.weissmaller;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReceiptTest {

    @Test
    public void calculateReceiptTest(){

        Price price = new Price(Product.APPLE, new BigDecimal("0.25"), false);
        BigDecimal overall =  Receipt.calculatePrice(price, 3);
        assertThat(overall, is(new BigDecimal("0.75")));

    }

    @Test
    public void calculateReceiptOnSaleDividedByThreeTest(){

        Price price = new Price(Product.APPLE, new BigDecimal("0.25"), true);

        BigDecimal overall1 =  Receipt.calculatePrice(price, 3);
        assertThat(overall1, is(new BigDecimal("0.50")));

        BigDecimal overall2 =  Receipt.calculatePrice(price, 9);
        assertThat(overall2, is(new BigDecimal("1.50")));

    }

    @Test
    public void calculateReceiptOnSaleNotDividedByThreeTest(){

        Price price = new Price(Product.APPLE, new BigDecimal("0.25"), true);

        BigDecimal overall1 =  Receipt.calculatePrice(price, 4);
        assertThat(overall1, is(new BigDecimal("0.75")));


        BigDecimal overall2 =  Receipt.calculatePrice(price, 10);
        assertThat(overall2, is(new BigDecimal("1.75")));

    }
}
