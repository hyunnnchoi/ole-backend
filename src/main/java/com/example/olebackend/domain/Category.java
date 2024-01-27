package com.example.olebackend.domain;

import com.example.olebackend.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;

    @OneToMany(mappedBy = "category")
    @Builder.Default
    private List<SubCategory> subCategories = new ArrayList<>();

}
