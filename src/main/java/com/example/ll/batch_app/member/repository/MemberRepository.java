package com.example.ll.batch_app.member.repository;

import com.example.ll.batch_app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
