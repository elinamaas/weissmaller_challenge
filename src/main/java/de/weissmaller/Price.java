package de.weissmaller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Price {

    private Product product;
    private BigDecimal price;
    private boolean sale;
    private NumberFormat currency;

    public Price() {
    }

    public Price(Product product, BigDecimal price, boolean sale) {
        this.product = product;
        this.price = price;
        this.sale = sale;
        this.currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    }

    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public NumberFormat getCurrency() {
        return currency;
    }

    public void setCurrency(NumberFormat currency) {
        this.currency = currency;
    }
}
