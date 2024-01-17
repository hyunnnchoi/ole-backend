package com.example.olebackend.domain;

import com.example.olebackend.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category extends BaseEntity {

    @Id @GeneratedValue
    private Long id ;

    private String name ;

    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategories = new ArrayList<>();

}
