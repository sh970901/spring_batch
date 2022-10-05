package com.example.ll.batch_app.app.cash.service;

import com.example.ll.batch_app.app.cash.entity.CashLog;
import com.example.ll.batch_app.app.cash.repository.CashLogRepository;
import com.example.ll.batch_app.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashLogRepository cashLogRepository;

    public CashLog addCash(Member member, long changePrice, String eventType) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(changePrice)
                .eventType(eventType)
                .build();

        cashLogRepository.save(cashLog);

        return cashLog;
    }
}
