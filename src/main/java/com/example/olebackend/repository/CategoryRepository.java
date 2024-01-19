package com.example.olebackend.repository;

import com.example.olebackend.domain.Category;
import com.example.olebackend.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
