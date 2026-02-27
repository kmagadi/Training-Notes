package com.trading;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class Product {
    private String productID;
    private String productName;
    private String productType;
    private double price;
}
