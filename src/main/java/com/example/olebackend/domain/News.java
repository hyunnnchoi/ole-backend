package com.example.olebackend.domain;

import com.example.olebackend.domain.common.BaseEntity;
import com.example.olebackend.domain.enums.NewsCategory;
import com.example.olebackend.domain.mapping.CommunityComment;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class News extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private NewsCategory category;

    private String author;

    private String imageUrl;

    @ColumnDefault("0")
    private int views;

    public void incrementViews() {
        this.views++;
    }

    @OneToMany(mappedBy = "news", cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<File> fileList = new ArrayList<>();

    @OneToMany(mappedBy = "news", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<NewsImage> imageList = new ArrayList<>();
}
