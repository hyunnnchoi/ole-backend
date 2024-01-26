package com.example.olebackend.domain;

import com.example.olebackend.domain.common.BaseEntity;
import com.example.olebackend.domain.enums.CommunityCategory;
import com.example.olebackend.domain.mapping.CommunityComments;
import com.example.olebackend.domain.mapping.CommunityLikes;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Community extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    @Enumerated(EnumType.STRING)
    private CommunityCategory category;

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<CommunityLikes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<CommunityComments> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
