package de.weissmaller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Receipt {

    private Product product;
    private BigDecimal price;
    private int amount;
    private BigDecimal overallPrice;
    private NumberFormat currency;
    private boolean onSale;

    public Receipt() {
    }

    public Receipt(Price price, int amount) {
        this.product = price.getProduct();
        this.amount = amount;
        this.currency = price.getCurrency();
        this.onSale = price.isSale();
        this.price = price.getPrice();
        this.overallPrice = calculatePrice(price, amount);

    }

    public Receipt(Product product, int amount) {
        this.product = product;
        this.amount = amount;
        this.overallPrice = null;

    }

    public static BigDecimal calculatePrice(Price price, int amount) {
        if (price.isSale() && amount > 2) {
            if (amount % 3 == 0) {
                return price.getPrice().multiply(BigDecimal.valueOf(amount / 3 * 2));
            } else {
                int batch = amount / 3;
                int rest = amount - batch * 3;
                BigDecimal endPrice = price.getPrice().multiply(BigDecimal.valueOf(batch * 2))
                        .add(price.getPrice().multiply(BigDecimal.valueOf(rest)));
                return endPrice;
            }
        } else {
            return price.getPrice().multiply(BigDecimal.valueOf(amount));
        }
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(BigDecimal overallPrice) {
        this.overallPrice = overallPrice;
    }

    public NumberFormat getCurrency() {
        return currency;
    }

    public void setCurrency(NumberFormat currency) {
        this.currency = currency;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

}
