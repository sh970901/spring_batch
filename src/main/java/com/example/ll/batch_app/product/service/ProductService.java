package com.example.ll.batch_app.product.service;

import com.example.ll.batch_app.product.entity.Product;
import com.example.ll.batch_app.product.entity.ProductOption;
import com.example.ll.batch_app.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(String name, int price, int wholesalePrice, String makerShopName, List<ProductOption> options) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .wholesalePrice(wholesalePrice)
                .makerShopName(makerShopName)
                .build();

        for ( ProductOption option : options ) {
            product.addOption(option);
        }

        productRepository.save(product);
        return product;
    }
}
