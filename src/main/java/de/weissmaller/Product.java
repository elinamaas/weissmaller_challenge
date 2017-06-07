package de.weissmaller;

public enum Product {

    APPLE("apple"),
    ORANGE("orange"),
    GARLIC("garlic"),
    BANANA("banana"),
    PAPAYA("papaya");

    private String value;

    Product(String name){
        this.value = name;
    }

    public String getProductName(){
        return this.value;
    }

    public static Product getByName(String name){
        if(name.endsWith("s")){
            name = name.substring(0,name.length()-1);
        }
        for(Product product : values()){
            if(product.getProductName().equals(name)){
                return product;
            }
        }
        throw new IllegalArgumentException(name + " is not a valid productName");
    }
}
