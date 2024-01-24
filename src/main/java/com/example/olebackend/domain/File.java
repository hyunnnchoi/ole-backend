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

    private String path ;

    private String name ;

    private boolean represent ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id" )
    private Lesson lesson ;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id" )
    private Member member;

}
