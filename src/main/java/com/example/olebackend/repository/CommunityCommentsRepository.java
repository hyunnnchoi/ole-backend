package com.example.olebackend.repository;

import com.example.olebackend.domain.mapping.CommunityComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityCommentsRepository extends JpaRepository<CommunityComments, Long> {
}
