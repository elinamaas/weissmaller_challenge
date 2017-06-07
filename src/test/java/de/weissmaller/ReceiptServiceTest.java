package de.weissmaller;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ReceiptServiceTest {

    @Test
    public void calculateReceiptTest() {
        ReceiptService receiptService = new ReceiptService();

        Basket basket = new Basket();
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.APPLE);
        basket.addProduct(Product.ORANGE);
        basket.addProduct(Product.ORANGE);
        basket.addProduct(Product.ORANGE);
        basket.addProduct(Product.ORANGE);
        basket.addProduct(Product.ORANGE);

        List<Receipt> receiptList = receiptService.calculateReceipt(basket);

        assertThat(receiptList.size(), is(2));
        receiptList.forEach(receipt -> {
            if (receipt.getProduct().equals(Product.APPLE)){
                assertThat(receipt.getOverallPrice(), is(new BigDecimal("1.00")));
            }else{
                assertThat(receipt.getOverallPrice(), is(new BigDecimal("1.50")));

            }
        });
    }
}
