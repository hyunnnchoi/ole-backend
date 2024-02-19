package com.example.olebackend.repository.specification;

import com.example.olebackend.domain.Category;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.SubCategory;
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
//            Join<Lesson, LectureTeacher> lectureTeacherJoin = root.join("lectureTeacherList", JoinType.INNER);
//            Join<LectureTeacher, Teacher> teacherJoin = lectureTeacherJoin.join("teacher", JoinType.INNER);
//            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(teacherJoin.get("name")), likePattern));

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
    public static Specification<Lesson> findByCategoryId(Long categoryId) {
        return (root, query, criteriaBuilder) -> {
            Join<Lesson, SubCategory> subCategoryJoin = root.join("subCategory", JoinType.INNER);
            Join<SubCategory, Category> categoryJoin = subCategoryJoin.join("category", JoinType.INNER);
            return criteriaBuilder.equal(categoryJoin.get("id"), categoryId);
        };
    }


}
