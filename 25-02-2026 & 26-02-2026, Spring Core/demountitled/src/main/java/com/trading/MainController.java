package com.trading;

public class MainController {
        public static void main(String[] args)
        {
            User newUse = new User("Virat", "90", "BLR");
            System.out.println(newUse);

            Product prod = Product.builder()
                    .productID("69")
                    .build();
            System.out.println(prod.getProductID());
        }
}
