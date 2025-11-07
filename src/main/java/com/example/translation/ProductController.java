package com.example.translation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(
            @PathVariable Long id,
            @RequestHeader(value = "Accept-Language", defaultValue = "en") String lang) {

        return ResponseEntity.ok(productService.getProductByLang(id, lang));
    }
}

