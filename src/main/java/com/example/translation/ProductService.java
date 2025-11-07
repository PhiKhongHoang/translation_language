package com.example.translation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductTranslationRepository translationRepository;

    public ProductResponse getProductByLang(Long id, String lang) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductTranslation t = translationRepository.findByProductIdAndLang(id, lang)
                .orElse(null);

        return ProductResponse.builder()
                .id(product.getId())
                .sku(product.getSku())
                .price(product.getBasePrice())
                .name(t != null ? t.getName() : "N/A")
                .description(t != null ? t.getDescription() : "")
                .build();
    }
}

