package com.example.translation;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Product_Translation")
@Data
public class ProductTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lang;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}