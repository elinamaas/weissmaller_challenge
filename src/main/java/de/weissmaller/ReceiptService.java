package de.weissmaller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReceiptService {

    public ReceiptService() {}

    public  List<Receipt> calculateReceipt(Basket basket) {
        InitService initService = new InitService();
        BasketService basketService = new BasketService();
        HashMap<Product, Price> productPriceMap = initService.initializePrices();
        HashMap<Product, Integer> productInBasket = basketService.productAmount(basket);
        List<Receipt> receiptList = new ArrayList<>();
        productInBasket.forEach((product, amount) -> {
            if (productPriceMap.containsKey(product)) {
                Receipt receipt = new Receipt(productPriceMap.get(product), amount);
                receiptList.add(receipt);
            } else {
                Receipt receipt = new Receipt(product, amount);
                receiptList.add(receipt);
            }
        });
        return receiptList;

    }

    public void printReceipt(List<Receipt> receiptList) {
        System.out.println("Your receipt:\n");
        BigDecimal overallPrice = new BigDecimal("0");
        for (Receipt receipt : receiptList) {
            print(receipt);
            if (receipt.getOverallPrice() != null) {
                overallPrice = overallPrice.add(receipt.getOverallPrice());
            }
        }
        System.out.println("To pay: " + overallPrice + "EUR");

    }

    private void print(Receipt receipt) {
        if (receipt.getOverallPrice() == null) {
            System.out.println("There is no price for " + receipt.getProduct());
        } else {
            System.out.println(receipt.getProduct() + "\t\t" + receipt.getPrice() + receipt.getCurrency().getCurrency());
            if (receipt.isOnSale()) {
                System.out.println(receipt.getAmount() + " SALE " + receipt.getOverallPrice() + "EUR");
            } else {
                System.out.println(receipt.getAmount() + "\t\t\t\t" + receipt.getOverallPrice() + "EUR");

            }
        }
    }
}
