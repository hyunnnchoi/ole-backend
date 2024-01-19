package com.example.olebackend.repository;

import com.example.olebackend.domain.NonMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonMemberRepository extends JpaRepository<NonMember, Long> {

}
