package com.example.ll.batch_app.app.cash.entity;


import com.example.ll.batch_app.app.member.entity.Member;
import com.example.ll.batch_app.app.base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class CashLog extends BaseEntity {//사용자가 충전한 돈을 기록
    @ManyToOne(fetch = LAZY)
    private Member member;
    private long price; // 변동
    private String eventType;
}
