package de.weissmaller;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Add products by typing their name in the basket.\n" +
                "We have oranges, apples, garlics, papayas. \n" +
                "\"Enter\" will add product to your basket. \n" +
                "When you are finished please press \"Enter\". ");
        Basket basket = new Basket();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\\r\\n]+");
        String productName = "product";
        while (!productName.isEmpty()) {
            productName = scanner.nextLine();
            if(!productName.isEmpty()){
                basket.addProduct(productName);
            }
        }

        ReceiptService receiptService = new ReceiptService();
        List<Receipt> receiptList = receiptService.calculateReceipt(basket);
        receiptService.printReceipt(receiptList);
    }


}
