package com.example.olebackend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(columnDefinition = "VARCHAR(255) default 'resources/static/default.jpeg'")
    private String path ;

    private String name ;

    @Column(columnDefinition = "BOOLEAN default TRUE")
    private boolean represent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id" )
    private Lesson lesson ;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id" )
    private Member member;

}
