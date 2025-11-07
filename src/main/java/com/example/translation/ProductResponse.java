package com.example.translation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String sku;
    private Double price;
    private String name;
    private String description;
}
