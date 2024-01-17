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
public class SubCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id" )
    private Category category ;

    @OneToMany(mappedBy = "subCategory")
    private List<Lesson> lessons = new ArrayList<>() ;
}
