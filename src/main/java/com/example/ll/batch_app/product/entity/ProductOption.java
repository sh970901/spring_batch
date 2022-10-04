package com.example.ll.batch_app.product.entity;

import com.example.ll.batch_app.base.entity.BaseEntity;
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
public class ProductOption extends BaseEntity {
    private String color;
    private String size;

    //기존 color와 size의 변경이 일어났을때 기존 칼럼에 추가하는것은 좋지 않음

    //보여주기위한 color와 size 빨강이 아닌 감성빨강, 전산에서는 color 노출용으로는 displayColor 
    private String displayColor;
    private String displaySize;

    private int price;
    private int wholesalePrice;
    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private Product product;

    private boolean isSoldOut; // 사입처에서의 품절여부
    private int stockQuantity; // 쇼핑몰에서 보유한 물건 개수

    public ProductOption(String color, String size) {
        this.color = color;
        this.displayColor = color;
        this.size = size;
        this.displaySize = size;
    }

    public boolean isOrderable(int quantity) {
        if (isSoldOut() == false) return true;

        return getStockQuantity() >= quantity;
    }
}
