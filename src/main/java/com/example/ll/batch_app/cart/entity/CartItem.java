package com.example.ll.batch_app.cart.entity;

import com.example.ll.batch_app.base.entity.BaseEntity;
import com.example.ll.batch_app.member.entity.Member;
import com.example.ll.batch_app.product.entity.ProductOption;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class CartItem extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member member;
    @ManyToOne(fetch = LAZY)
    private ProductOption productOption;
    private int quantity; // 쇼핑몰에서 보유한 물건 개수
}
