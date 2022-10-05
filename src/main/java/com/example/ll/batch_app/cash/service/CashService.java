package com.example.ll.batch_app.cash.service;

import com.example.ll.batch_app.cash.entity.CashLog;
import com.example.ll.batch_app.cash.repository.CashLogRepository;
import com.example.ll.batch_app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashLogRepository cashLogRepository;

    public CashLog addCash(Member member, long changePrice) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(changePrice)
                .build();

        cashLogRepository.save(cashLog);

        return cashLog;
    }
}