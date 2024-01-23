package com.example.olebackend.repository.specification;

import com.example.olebackend.domain.Lesson;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LessonSpecification {

    public static Specification<Lesson> findByPriceStatus(Boolean priceStatus) {
        return new Specification<Lesson>() {
            @Override
            public Predicate toPredicate(Root<Lesson> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("priceStatus"), priceStatus);
            }
        };
    }

    public static Specification<Lesson> findByGatherStatus(Boolean gatherStatus) {
        return new Specification<Lesson>() {
            @Override
            public Predicate toPredicate(Root<Lesson> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("gatherStatus"), gatherStatus);
            }
        };
    }

    public static Specification<Lesson> findByKeyword(String keyword) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            String likePattern = "%" + keyword.toLowerCase() + "%";

            Field[] fields = Lesson.class.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == String.class) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(field.getName())), likePattern));
                }
            }

            Join<Object, Object> teachersJoin = root.join("lectureTeacherList").join("teacher");
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(teachersJoin.get("name")), likePattern));

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }


}
