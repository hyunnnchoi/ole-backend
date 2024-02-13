package com.example.olebackend.repository.specification;

import com.example.olebackend.domain.News;
import com.example.olebackend.domain.enums.NewsCategory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NewsSpecification {

    public static Specification<News> findByCategory(NewsCategory category) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), category);
    }

    public static Specification<News> findByKeyword(String keyword) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            String likePattern = "%" + keyword.toLowerCase() + "%";

            Field[] fields = News.class.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == String.class) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(field.getName())), likePattern));
                }
            }

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
}
