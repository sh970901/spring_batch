package com.example.ll.batch_app.cart.service;

import com.example.ll.batch_app.cart.entity.CartItem;
import com.example.ll.batch_app.cart.repository.CartItemRepository;
import com.example.ll.batch_app.member.entity.Member;
import com.example.ll.batch_app.product.entity.ProductOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;

    public void addItem(Member member, ProductOption productOption, int quantity) {
        CartItem cartItem = CartItem.builder()
                .member(member)
                .productOption(productOption)
                .quantity(quantity)
                .build();

        cartItemRepository.save(cartItem);
    }
}
