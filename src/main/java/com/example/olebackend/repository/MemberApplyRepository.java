package com.example.olebackend.repository;

import com.example.olebackend.domain.mapping.MemberApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberApplyRepository extends JpaRepository<MemberApply, Long> {
}
